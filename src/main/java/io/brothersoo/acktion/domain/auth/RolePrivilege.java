package io.brothersoo.acktion.domain.auth;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.brothersoo.acktion.domain.BaseTimeStampEntity;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "acktion_role_privilege")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RolePrivilege extends BaseTimeStampEntity {

  @Id
  @Column(name = "acktion_role_privilege_id", columnDefinition = "BINARY(16)")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID id;

  @ManyToOne(targetEntity = Role.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "acktion_role_id")
  @JsonBackReference
  private Role role;

  @ManyToOne(targetEntity = Privilege.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "acktion_privilege_id")
  @JsonBackReference
  private Privilege privilege;

  @Builder
  public RolePrivilege(UUID id, Role role, Privilege privilege) {
    this.id = id;
    this.role = role;
    this.privilege = privilege;
  }
}
