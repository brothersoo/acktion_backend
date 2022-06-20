package io.brothersoo.acktion.domain.auth;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.brothersoo.acktion.domain.BaseTimeStampEntity;
import io.brothersoo.acktion.domain.user.User;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "acktion_user_role")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserRole extends BaseTimeStampEntity {

  @Id
  @Column(name = "acktion_user_role_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "acktion_user_id")
  @JsonBackReference
  private User user;

  @ManyToOne(targetEntity = Role.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "acktion_role_id")
  @JsonBackReference
  private Role role;

  @Builder
  public UserRole(Long id, User user, Role role) {
    this.id = id;
    this.user = user;
    this.role = role;
  }
}
