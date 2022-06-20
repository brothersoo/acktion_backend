package io.brothersoo.acktion.service.auth;

import io.brothersoo.acktion.dto.user.SimpleUserInfo;
import io.brothersoo.acktion.dto.user.UserRegisterRequest;

public interface AuthService {

  SimpleUserInfo registerUser(UserRegisterRequest request);
}
