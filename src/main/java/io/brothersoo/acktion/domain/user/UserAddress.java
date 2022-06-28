package io.brothersoo.acktion.domain.user;

import io.brothersoo.acktion.domain.BaseTimeStampEntity;
import java.util.UUID;
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
@Table(name = "acktion_user_address")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserAddress extends BaseTimeStampEntity {

  @Id
  @Column(name = "acktion_user_address_id", columnDefinition = "BINARY(16)")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID id;

  @Column(name = "base_address")
  private String baseAddress;

  @Column(name = "detail_address")
  private String detailAddress;

  @Column(name = "zipcode")
  private String zipcode;

  @Column(name = "is_default_address")
  private Boolean isDefaultAddress;

  @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "acktion_user_id")
  private User user;

  @Builder
  public UserAddress(
      String baseAddress, String detailAddress, String zipcode, Boolean isDefaultAddress, User user
  ) {
    this.baseAddress = baseAddress;
    this.detailAddress = detailAddress;
    this.zipcode = zipcode;
    this.isDefaultAddress = isDefaultAddress;
    this.user = user;
  }
}
