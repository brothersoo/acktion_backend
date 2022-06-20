package io.brothersoo.acktion.repository.role;

import io.brothersoo.acktion.domain.auth.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
