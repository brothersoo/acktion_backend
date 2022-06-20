package io.brothersoo.acktion.util;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;
import java.util.List;
import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthUtil {

  private final Algorithm jwtAlgorithm;

  public String generateToken(String encryptedToken, Date expireDate) {
    DecodedJWT decodedJWT = this.decodeJWT(encryptedToken);
    return JWT.create()
        .withSubject(decodedJWT.getSubject())
        .withExpiresAt(expireDate)
        .withIssuer(decodedJWT.getIssuer())
        .sign(jwtAlgorithm);
  }

  public String generateAccessToken(String subject, List<String> roles, String issuer) {
    return JWT.create()
        .withSubject(subject)
        .withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
        .withIssuer(issuer)
        .withClaim("roles", roles)
        .sign(jwtAlgorithm);
  }

  public String generateRefreshToken(String subject, String issuer) {
    return JWT.create()
        .withSubject(subject)
        .withExpiresAt(new Date(System.currentTimeMillis() + 20 * 24 * 60 * 60 * 1000))
        .withIssuer(issuer)
        .sign(jwtAlgorithm);
  }

  public DecodedJWT decodeJWT(String jwt) {
    JWTVerifier verifier = JWT.require(jwtAlgorithm).build();
    return verifier.verify(jwt);
  }

  public String isBearer(HttpServletRequest request) throws AuthException {
    String authorizationHeader = request.getHeader(AUTHORIZATION);
    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
      return authorizationHeader.substring("Bearer ".length());
    } else {
      throw new AuthException("invalid bearer token");
    }
  }
}
