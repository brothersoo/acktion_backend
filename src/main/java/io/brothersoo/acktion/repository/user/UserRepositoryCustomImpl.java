package io.brothersoo.acktion.repository.user;

import static io.brothersoo.acktion.domain.auth.QPrivilege.privilege;
import static io.brothersoo.acktion.domain.auth.QRole.role;
import static io.brothersoo.acktion.domain.auth.QRolePrivilege.rolePrivilege;
import static io.brothersoo.acktion.domain.auth.QUserRole.userRole;
import static io.brothersoo.acktion.domain.user.QUser.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.brothersoo.acktion.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

  private final JPAQueryFactory queryFactory;

  @Override
  public User findByUsernameFetchPrivilege(String username) {
    return queryFactory.selectFrom(user)
        .join(user.userRoles, userRole).fetchJoin()
        .join(userRole.role, role).fetchJoin()
        .join(role.rolePrivileges, rolePrivilege).fetchJoin()
        .join(rolePrivilege.privilege, privilege).fetchJoin()
        .where(user.username.eq(username))
        .fetchOne();
  }

  @Override
  public User findByNicknameFetchPrivilege(String nickname) {
    return queryFactory.selectFrom(user)
        .join(user.userRoles, userRole).fetchJoin()
        .join(userRole.role, role).fetchJoin()
        .join(role.rolePrivileges, rolePrivilege).fetchJoin()
        .join(rolePrivilege.privilege, privilege).fetchJoin()
        .where(user.nickname.eq(nickname))
        .fetchOne();
  }

  @Override
  public Long countByUsernameOrNickname(String username, String nickname) {
    return queryFactory.select(user.count())
        .from(user)
        .where(user.username.eq(username)
            .or(user.nickname.eq(nickname)))
        .fetchOne();
  }
}
