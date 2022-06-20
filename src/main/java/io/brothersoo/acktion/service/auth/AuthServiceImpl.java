package io.brothersoo.acktion.service.auth;

import static io.brothersoo.acktion.domain.auth.RoleName.MEMBER;

import io.brothersoo.acktion.domain.user.User;
import io.brothersoo.acktion.dto.user.SimpleUserInfo;
import io.brothersoo.acktion.dto.user.UserRegisterRequest;
import io.brothersoo.acktion.repository.user.UserRepository;
import io.brothersoo.acktion.service.role.RoleService;
import io.brothersoo.acktion.validator.AuthValidator;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService, UserDetailsService {

  private final UserRepository userRepository;
  private final RoleService roleService;
  private final PasswordEncoder encoder;
  private final AuthValidator authValidator;
  private final ModelMapper modelMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = findUserByUsernameAndValidate(username);

    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    for (String privilegeName : user.getAllPrivilegeNames()) {
      authorities.add(new SimpleGrantedAuthority(privilegeName));
    }

    return new org.springframework.security.core.userdetails.User(
        user.getUsername(), user.getPassword(), authorities
    );
  }

  @Override
  @Transactional
  public SimpleUserInfo registerUser(UserRegisterRequest request) {
    authValidator.userRegisterValidation(
        request.getPassword(), request.getPasswordConfirm(),
        userRepository.countByUsernameOrNickname(request.getUsername(), request.getNickname())
    );
    User user = new User(request);
    user.encryptPrivacy(encoder);
    User persistedUser = userRepository.save(user);
    roleService.grantRoleToUser(persistedUser, MEMBER.name());
    return modelMapper.map(persistedUser, SimpleUserInfo.class);
  }

  private User findUserByUsernameAndValidate(String username) {
    User user = userRepository.findByUsernameFetchPrivilege(username);
    if (user == null) {
      throw new UsernameNotFoundException("user not found with the given username");
    }
    return user;
  }
}
