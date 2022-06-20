package io.brothersoo.acktion.repository.user;


import io.brothersoo.acktion.domain.user.User;

public interface UserRepositoryCustom {

  User findByUsernameFetchPrivilege(String username);

  User findByNicknameFetchPrivilege(String nickname);

  Long countByUsernameOrNickname(String username, String nickname);
}
