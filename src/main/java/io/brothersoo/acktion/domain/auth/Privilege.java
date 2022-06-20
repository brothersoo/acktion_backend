package io.brothersoo.acktion.domain.auth;

import io.brothersoo.acktion.domain.BaseTimeStampEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "acktion_privilege")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Privilege extends BaseTimeStampEntity {

  @Id
  @Column(name = "acktion_privilege_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Builder
  public Privilege(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
