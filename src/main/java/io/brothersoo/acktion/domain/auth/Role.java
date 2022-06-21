package io.brothersoo.acktion.domain.auth;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.brothersoo.acktion.domain.BaseTimeStampEntity;
import java.util.Set;
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

@Entity
@Table(name = "acktion_role")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Role extends BaseTimeStampEntity {

  @Id
  @Column(name = "acktion_role_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @OneToMany(targetEntity = RolePrivilege.class, mappedBy = "role")
  @JsonManagedReference
  private Set<RolePrivilege> rolePrivileges;

  @Builder
  public Role(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
