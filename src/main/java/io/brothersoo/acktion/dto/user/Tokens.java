package io.brothersoo.acktion.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tokens {

  private String accessToken;
  private String refreshToken;
}
