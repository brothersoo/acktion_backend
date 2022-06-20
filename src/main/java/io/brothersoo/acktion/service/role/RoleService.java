package io.brothersoo.acktion.service.role;

import io.brothersoo.acktion.domain.user.User;

public interface RoleService {

  Long grantRoleToUser(User user, String roleName);
}
