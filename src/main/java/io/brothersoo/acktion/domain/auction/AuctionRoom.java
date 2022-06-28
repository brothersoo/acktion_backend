package io.brothersoo.acktion.domain.auction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.brothersoo.acktion.domain.BaseTimeStampEntity;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "acktion_auction_room")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AuctionRoom extends BaseTimeStampEntity {

  @Id
  @Column(name = "acktion_auction_room_id", columnDefinition = "BINARY(16)")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column
  @Enumerated(value = EnumType.STRING)
  private AuctionRoomStatus status;

  @OneToOne(targetEntity = AuctionProduct.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "acktion_auction_product_id")
  private AuctionProduct auctionProduct;

  @OneToMany(targetEntity = AuctionRoomParticipation.class, mappedBy = "auctionRoom")
  @JsonBackReference
  private List<AuctionRoomParticipation> auctionRoomParticipants;

  @Builder
  public AuctionRoom(
      UUID id, String name, AuctionRoomStatus status, AuctionProduct auctionProduct
  ) {
    this.id = id;
    this.name = name;
    this.status = status;
    this.auctionProduct = auctionProduct;
  }
}
