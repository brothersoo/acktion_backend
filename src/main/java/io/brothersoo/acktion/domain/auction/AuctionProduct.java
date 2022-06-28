package io.brothersoo.acktion.domain.auction;

import io.brothersoo.acktion.domain.BaseTimeStampEntity;
import io.brothersoo.acktion.domain.user.User;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "acktion_auction_product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AuctionProduct extends BaseTimeStampEntity {

  @Id
  @Column(name = "acktion_auction_product_id", columnDefinition = "BINARY(16)")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "starting_price")
  private Long startingPrice;

  @Column(name = "status")
  @Enumerated(value = EnumType.STRING)
  private AuctionProductStatus status;

  @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "acktion_user_id")
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
