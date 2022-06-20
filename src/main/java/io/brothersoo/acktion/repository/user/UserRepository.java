package io.brothersoo.acktion.repository.user;

import io.brothersoo.acktion.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

}
