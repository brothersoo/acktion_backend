package io.brothersoo.acktion.domain.auction;

import io.brothersoo.acktion.domain.BaseTimeStampEntity;
import io.brothersoo.acktion.domain.auction.AuctionProduct;
import io.brothersoo.acktion.domain.user.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "acktion_successful_product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class SuccessfulAuctionProduct extends BaseTimeStampEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "acktion_successful_product_id")
  private Long id;

  @Column(name = "hammer_price")
  private Long hammerPrice;

  @Column(name = "bidder_name")
  private String bidderName;  // 낙찰자명

  @Column(name = "cosigner_name")
  private String cosignerName;  // 위탁자명

  @OneToOne(targetEntity = AuctionProduct.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "acktion_auction_product_id")
  private AuctionProduct auctionProduct;

  @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "acktion_bidder_id")
  private User bidder; // 낙찰자

  @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "acktion_cosigner_id")
  private User cosigner; // 낙찰자

  @Builder
  public SuccessfulAuctionProduct(
      Long hammerPrice, String bidderName, String cosignerName,
      AuctionProduct auctionProduct, User bidder, User cosigner
  ) {
    this.hammerPrice = hammerPrice;
    this.bidderName = bidderName;
    this.cosignerName = cosignerName;
    this.auctionProduct = auctionProduct;
    this.bidder = bidder;
    this.cosigner = cosigner;
  }
}
