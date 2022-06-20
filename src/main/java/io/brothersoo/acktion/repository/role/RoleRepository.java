package io.brothersoo.acktion.repository.role;

import io.brothersoo.acktion.domain.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

  Role findByName(String name);
}
