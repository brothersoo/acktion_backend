package io.brothersoo.acktion.respository.user;

import static io.brothersoo.acktion.domain.auth.RoleName.MEMBER;
import static org.assertj.core.api.Assertions.assertThat;

import io.brothersoo.acktion.domain.user.User;
import io.brothersoo.acktion.repository.user.UserRepository;
import io.brothersoo.acktion.service.role.RoleService;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserRepositoryTest {

  @Autowired
  EntityManager entityManager;
  @Autowired
  UserRepository userRepository;
  @Autowired
  RoleService roleService;
  @Autowired
  DataSource dataSource;

  private User coolUser;
  private String username;
  private String nickname;

  @BeforeAll
  void beforeAll() {
    try (Connection conn = dataSource.getConnection()) {
      ScriptUtils.executeSqlScript(
          conn,
          new ClassPathResource("db/ddl/RolePrivilege.sql")
      );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @BeforeEach
  void beforeEach() {
    username = "CoolGuy";
    nickname = "CoolGuy123";
    User user = User.builder()
        .username(username)
        .password("unencryptedPassword")
        .nickname(nickname)
        .phoneNumber("010-1111-1111")
        .auctionRoomParticipations(new ArrayList<>())
        .boughtProducts(new ArrayList<>())
        .cosignedProducts(new ArrayList<>())
        .addresses(new ArrayList<>())
        .userRoles(new HashSet<>())
        .build();
    roleService.grantRoleToUser(user, MEMBER.name());
    entityManager.persist(user);
    coolUser = user;
  }

  @Test
  @DisplayName("username으로 권한과 함께 사용자 불러오기 테스트 성공")
  void findByUsernameFetchPrivilegeSuccessTest() {
    // when
    User user = userRepository.findByUsernameFetchPrivilege(username);

    // then
    assertThat(user).isEqualTo(coolUser);
  }

  @Test
  @DisplayName("nickname으로 권한과 함께 사용자 불러오기 테스트 성공")
  void findByNicknameFetchPrivilegeSuccessTest() {
    // when
    User user = userRepository.findByNicknameFetchPrivilege(nickname);

    // then
    assertThat(user).isEqualTo(coolUser);
  }

  @Test
  @DisplayName("등록되어있는 사용자 수 가져오기 테스트 성공")
  void registeredUserCountByUsernameOrNicknameSuccessTest() {
    // given

    // when
    Long count = userRepository.countByUsernameOrNickname(username, nickname);

    //then
    assertThat(count).isEqualTo(1L);
  }

  @Test
  @DisplayName("등록되어있지 않은 사용자 수 가져오기 테스트 성공")
  void unregisteredUserCountByUsernameOrNicknameSuccessTest() {
    // given

    // when
    Long count = userRepository.countByUsernameOrNickname("sillyName", "inappropriateName");

    //then
    assertThat(count).isZero();
  }
}
