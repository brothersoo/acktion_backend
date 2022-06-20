package io.brothersoo.acktion.dto.user;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {

  @NotEmpty
  private String username;
  @NotEmpty
  private String password;
  @NotEmpty
  private String passwordConfirm;
  @NotEmpty
  private String nickname;
  @NotEmpty
  private String phoneNumber;
}
