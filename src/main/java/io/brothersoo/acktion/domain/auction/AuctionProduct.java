package io.brothersoo.acktion.domain.auction;

import io.brothersoo.acktion.domain.BaseTimeStampEntity;
import io.brothersoo.acktion.domain.user.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "acktion_auction_product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AuctionProduct extends BaseTimeStampEntity {

  @Id
  @Column(name = "acktion_auction_product_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "starting_price")
  private Long startingPrice;

  @Column(name = "status")
  @Enumerated(value = EnumType.STRING)
  private AuctionProductStatus status;

  @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "acktion_cosigner_id")
  private User cosigner;

  @Builder
  public AuctionProduct(
      String name, Long startingPrice, AuctionProductStatus status, User cosigner
  ) {
    this.startingPrice = startingPrice;
    this.status = status;
    this.cosigner = cosigner;
  }
}
