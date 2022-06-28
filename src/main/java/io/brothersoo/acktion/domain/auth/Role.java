package io.brothersoo.acktion.domain.auth;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.brothersoo.acktion.domain.BaseTimeStampEntity;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "acktion_role")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Role extends BaseTimeStampEntity {

  @Id
  @Column(name = "acktion_role_id", columnDefinition = "BINARY(16)")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID id;

  @Column(name = "name")
  private String name;

  @OneToMany(targetEntity = RolePrivilege.class, mappedBy = "role")
  @JsonManagedReference
  private Set<RolePrivilege> rolePrivileges;

  @Builder
  public Role(UUID id, String name) {
    this.id = id;
    this.name = name;
  }
}
