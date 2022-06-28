package io.brothersoo.acktion.domain.auction;

import io.brothersoo.acktion.domain.BaseTimeStampEntity;
import io.brothersoo.acktion.domain.user.User;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "acktion_successful_product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class SuccessfulAuctionProduct extends BaseTimeStampEntity {

  @Id
  @Column(name = "acktion_successful_product_id", columnDefinition = "BINARY(16)")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID id;

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
  @JoinColumn(name = "acktion_user_id")
  private User bidder; // 낙찰자

  @Builder
  public SuccessfulAuctionProduct(
      Long hammerPrice, String bidderName, String cosignerName,
      AuctionProduct auctionProduct, User bidder
  ) {
    this.hammerPrice = hammerPrice;
    this.bidderName = bidderName;
    this.cosignerName = cosignerName;
    this.auctionProduct = auctionProduct;
    this.bidder = bidder;
  }
}
