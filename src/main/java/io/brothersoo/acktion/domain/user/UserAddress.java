package io.brothersoo.acktion.domain.user;

import io.brothersoo.acktion.domain.BaseTimeStampEntity;
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
@Table(name = "acktion_user_address")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserAddress extends BaseTimeStampEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "acktion_user_address_id")
  private Long id;

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
