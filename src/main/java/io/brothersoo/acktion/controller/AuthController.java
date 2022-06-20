package io.brothersoo.acktion.controller;

import io.brothersoo.acktion.dto.user.SimpleUserInfo;
import io.brothersoo.acktion.dto.user.UserRegisterRequest;
import io.brothersoo.acktion.service.auth.AuthService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("/register")
  public ResponseEntity<SimpleUserInfo> userRegister(
      @Valid @RequestBody UserRegisterRequest request
  ) {
    return ResponseEntity.ok(authService.registerUser(request));
  }
}
