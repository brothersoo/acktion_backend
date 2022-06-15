package io.brothersoo.acktion.domain.auth;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.brothersoo.acktion.domain.BaseTimeStampEntity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 사용자의 권한 단계를 알리는 엔티티
 * 유저는 TEMP_USER, MEMBER, ADMIN 중 하나 혹은 여러개의 Role을 가지고 있습니다.
 */
@Entity
@Table(name = "ssg_role")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Role extends BaseTimeStampEntity {

  @Id
  @Column(name = "ssg_role_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @OneToMany(targetEntity = RolePrivilege.class, mappedBy = "role")
  @JsonManagedReference
  private List<RolePrivilege> rolePrivileges;

  @Builder
  public Role(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
