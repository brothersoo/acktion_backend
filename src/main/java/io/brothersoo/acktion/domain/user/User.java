package io.brothersoo.acktion.domain.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.brothersoo.acktion.domain.BaseTimeStampEntity;
import io.brothersoo.acktion.domain.auction.AuctionRoomParticipation;
import io.brothersoo.acktion.domain.auction.SuccessfulAuctionProduct;
import io.brothersoo.acktion.domain.auth.UserRole;
import io.brothersoo.acktion.dto.user.UserRegisterRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

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

  @OneToMany(targetEntity = AuctionRoomParticipation.class, mappedBy = "participant")
  @JsonManagedReference
  private List<AuctionRoomParticipation> auctionRoomParticipations;

  @OneToMany(targetEntity = SuccessfulAuctionProduct.class, mappedBy = "bidder")
  @JsonManagedReference
  private List<SuccessfulAuctionProduct> boughtProducts;

  @OneToMany(targetEntity = SuccessfulAuctionProduct.class, mappedBy = "cosigner")
  @JsonManagedReference
  private List<SuccessfulAuctionProduct> soldProducts;

  @OneToMany(targetEntity = UserAddress.class, mappedBy = "user")
  @JsonManagedReference
  private List<UserAddress> addresses;

  @OneToMany(targetEntity = UserRole.class, cascade = CascadeType.ALL, mappedBy = "user")
  @JsonManagedReference
  private Set<UserRole> userRoles;

  public User(UserRegisterRequest request) {
    this.username = request.getUsername();
    this.password = request.getPassword();
    this.nickname = request.getNickname();
    this.phoneNumber = request.getPhoneNumber();
    this.auctionRoomParticipations = new ArrayList<>();
    this.boughtProducts = new ArrayList<>();
    this.soldProducts = new ArrayList<>();
    this.addresses = new ArrayList<>();
    this.userRoles = new HashSet<>();
  }

  @Builder
  public User(
      String username, String password, String nickname, String phoneNumber,
      List<AuctionRoomParticipation> auctionRoomParticipations,
      List<SuccessfulAuctionProduct> boughtProducts,
      List<SuccessfulAuctionProduct> soldProducts,
      List<UserAddress> addresses,
      Set<UserRole> userRoles
  ) {
    this.username = username;
    this.password = password;
    this.nickname = nickname;
    this.phoneNumber = phoneNumber;
    this.auctionRoomParticipations = auctionRoomParticipations;
    this.boughtProducts = boughtProducts;
    this.soldProducts = soldProducts;
    this.addresses = addresses;
    this.userRoles = userRoles;
  }

  public List<String> getAllPrivilegeNames() {
    return this.userRoles.stream()
        .flatMap(userRole -> userRole.getRole().getRolePrivileges().stream())
        .map(rolePrivilege -> rolePrivilege.getPrivilege().getName())
        .collect(Collectors.toList());
  }

  public void encryptPrivacy(PasswordEncoder encoder) {
    password = encoder.encode(password);
    phoneNumber = encoder.encode(phoneNumber);
  }
}
