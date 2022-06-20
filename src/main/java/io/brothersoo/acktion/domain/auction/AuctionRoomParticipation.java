package io.brothersoo.acktion.domain.auction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.brothersoo.acktion.domain.BaseTimeStampEntity;
import io.brothersoo.acktion.domain.user.User;
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
@Table(name = "acktion_auction_room_participation")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AuctionRoomParticipation extends BaseTimeStampEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "acktion_auction_room_participation_id")
  private Long id;

  @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "acktion_user_id")
  @JsonBackReference
  private User participant;

  @ManyToOne(targetEntity = AuctionRoom.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "acktion_auction_room_id")
  @JsonBackReference
  private AuctionRoom auctionRoom;

  @Builder
  public AuctionRoomParticipation(User participant, AuctionRoom auctionRoom) {
    this.participant = participant;
    this.auctionRoom = auctionRoom;
  }
}
