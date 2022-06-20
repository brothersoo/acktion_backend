package io.brothersoo.acktion.validator;

import org.springframework.stereotype.Component;

@Component
public class AuthValidator {

  private boolean passwordConfirmMatches(String password, String passwordConfirm) {
    return password.equals(passwordConfirm);
  }

  private boolean isUsernameAndNickNameUsable(Long userWithGivenUsernameOrNicknameCount) {
    return userWithGivenUsernameOrNicknameCount == 0;
  }

  public void userRegisterValidation(String password, String passwordConfirm,
      Long userWithGivenUsernameOrNicknameCount) {
    if (!passwordConfirmMatches(password, passwordConfirm)
        || !isUsernameAndNickNameUsable(userWithGivenUsernameOrNicknameCount)) {
      throw new IllegalArgumentException("user register failed");
    }
  }
}
