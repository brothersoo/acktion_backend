package io.brothersoo.acktion.service.role;

import io.brothersoo.acktion.domain.user.User;
import java.util.UUID;

public interface RoleService {

  UUID grantRoleToUser(User user, String roleName);
}
