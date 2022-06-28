package io.brothersoo.acktion.domain.auth;

import io.brothersoo.acktion.domain.BaseTimeStampEntity;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "acktion_privilege")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Privilege extends BaseTimeStampEntity {

  @Id
  @Column(name = "acktion_privilege_id", columnDefinition = "BINARY(16)")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID id;

  @Column(name = "name")
  private String name;

  @Builder
  public Privilege(UUID id, String name) {
    this.id = id;
    this.name = name;
  }
}
