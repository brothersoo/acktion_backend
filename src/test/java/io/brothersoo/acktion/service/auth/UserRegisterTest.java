package io.brothersoo.acktion.service.auth;

import static org.assertj.core.api.Assertions.assertThat;

import io.brothersoo.acktion.domain.user.User;
import io.brothersoo.acktion.dto.user.SimpleUserInfo;
import io.brothersoo.acktion.dto.user.UserRegisterRequest;
import io.brothersoo.acktion.repository.user.UserRepository;
import io.brothersoo.acktion.service.role.RoleService;
import io.brothersoo.acktion.validator.AuthValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
class UserRegisterTest {

  @Mock
  UserRepository userRepository;
  @Mock
  RoleService roleService;
  @InjectMocks
  AuthServiceImpl authService;
  @Spy
  AuthValidator registerValidator;
  @Spy
  ModelMapper modelMapper;

  @Test
  @DisplayName("회원가입 성공 테스트")
  void userRegisterSuccessTest() {
    //given
    final String username = "CoolUsername";
    final String password = "safePassword";
    final String passwordConfirm = "safePassword";
    final String nickname = "CoolNickname";
    final String phoneNumber = "010-1111-1111";
    final Long userCountWithGivenUsernameOrNickname = 0L;
    UserRegisterRequest request = new UserRegisterRequest(
        username, password, passwordConfirm, nickname, phoneNumber
    );
    User user = new User(request);
    Mockito
        .when(userRepository.countByUsernameOrNickname(username, nickname))
        .thenReturn(userCountWithGivenUsernameOrNickname);
    Mockito
        .when(userRepository.save(Mockito.any(User.class)))
        .thenAnswer(new Answer<User>() {
          @Override
          public User answer(InvocationOnMock invocation) throws Throwable {
            Object[] args = invocation.getArguments();
            return (User) args[0];
          }
        });

    // when
    SimpleUserInfo res = authService.registerUser(request);

    // then
    assertThat(res.getUsername()).isEqualTo(username);
    assertThat(res.getNickname()).isEqualTo(nickname);
    Mockito
        .verify(userRepository, Mockito.times(1))
        .countByUsernameOrNickname(username, nickname);
    Mockito
        .verify(registerValidator, Mockito.times(1))
        .userRegisterValidation(password, passwordConfirm, userCountWithGivenUsernameOrNickname);
  }

  @Test
  @DisplayName("비밀번호 확인 불일치 회원가입 실패 테스트")
  void passwordConfirmMissMatchUserRegisterFailTest() {
    //given
    final String username = "CoolUsername";
    final String password = "safePassword";
    final String passwordConfirm = "notSafePassword";
    final String nickname = "CoolNickname";
    final String phoneNumber = "010-1111-1111";
    final Long userCountWithGivenUsernameOrNickname = 0L;
    UserRegisterRequest request = new UserRegisterRequest(
        username, password, passwordConfirm, nickname, phoneNumber
    );

    // when / then
    Assertions.assertThrows(
        IllegalArgumentException.class, () -> authService.registerUser(request)
    );

    Mockito
        .verify(userRepository, Mockito.times(1))
        .countByUsernameOrNickname(username, nickname);
    Mockito
        .verify(registerValidator, Mockito.times(1))
        .userRegisterValidation(password, passwordConfirm, userCountWithGivenUsernameOrNickname);
  }

  @Test
  @DisplayName("사용자 id 혹은 닉네임 중복 회원가입 실패 테스트")
  void duplicatedUsernameUserRegisterFailTest() {
    //given
    final String username = "CoolUsername";
    final String password = "safePassword";
    final String passwordConfirm = "safePassword";
    final String nickname = "CoolNickname";
    final String phoneNumber = "010-1111-1111";
    final Long userCountWithGivenUsernameOrNickname = 1L;
    UserRegisterRequest request = new UserRegisterRequest(
        username, password, passwordConfirm, nickname, phoneNumber
    );
    Mockito
        .when(userRepository.countByUsernameOrNickname(username, nickname))
        .thenReturn(userCountWithGivenUsernameOrNickname);

    // when / then
    Assertions.assertThrows(
        IllegalArgumentException.class, () -> authService.registerUser(request)
    );

    Mockito
        .verify(registerValidator, Mockito.times(1))
        .userRegisterValidation(password, passwordConfirm, userCountWithGivenUsernameOrNickname);
    Mockito
        .verify(userRepository, Mockito.times(1))
        .countByUsernameOrNickname(username, nickname);
  }
}
