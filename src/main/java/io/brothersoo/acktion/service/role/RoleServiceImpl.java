package io.brothersoo.acktion.service.role;

import io.brothersoo.acktion.domain.auth.Role;
import io.brothersoo.acktion.domain.auth.UserRole;
import io.brothersoo.acktion.domain.user.User;
import io.brothersoo.acktion.repository.role.RoleRepository;
import io.brothersoo.acktion.repository.role.UserRoleRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

  private static final String ROLE_PREFIX = "ROLE_";
  private final RoleRepository roleRepository;
  private final UserRoleRepository userRoleRepository;

  @Override
  @Transactional
  public UUID grantRoleToUser(User user, String roleName) {
    Role role = findRoleByNameAndValidate(roleName);
    UserRole userRole = UserRole.builder().user(user).role(role).build();
    UserRole persistedRole = userRoleRepository.save(userRole);
    return persistedRole.getId();
  }

  private Role findRoleByNameAndValidate(String roleName) {
    roleName = roleName.toUpperCase();
    Role role = roleRepository.findByName(ROLE_PREFIX + roleName);
    if (role == null) {
      throw new IllegalArgumentException("invalid role name");
    }
    return role;
  }
}
