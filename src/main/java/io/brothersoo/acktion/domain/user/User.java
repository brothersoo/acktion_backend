package io.brothersoo.acktion.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.brothersoo.acktion.domain.BaseTimeStampEntity;
import io.brothersoo.acktion.domain.auction.AuctionRoomParticipant;
import io.brothersoo.acktion.domain.auction.SuccessfulAuctionProduct;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "acktion_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User extends BaseTimeStampEntity {

  @Id
  @Column(name = "acktion_user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "nickname")
  private String nickname;

  @Column(name = "phone_number")
  private String phoneNumber;

  @OneToMany(targetEntity = AuctionRoomParticipant.class, mappedBy = "participant")
  @JsonManagedReference
  private List<AuctionRoomParticipant> auctionRoomParticipants;

  @OneToMany(targetEntity = SuccessfulAuctionProduct.class, mappedBy = "bidder")
  @JsonBackReference
  private List<SuccessfulAuctionProduct> boughtProducts;

  @OneToMany(targetEntity = SuccessfulAuctionProduct.class, mappedBy = "cosigner")
  @JsonBackReference
  private List<SuccessfulAuctionProduct> soldProducts;

  @OneToMany(targetEntity = UserAddress.class, mappedBy = "user")
  @JsonBackReference
  private List<UserAddress> addresses;
}
