package io.brothersoo.acktion.domain.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -415898072L;

    public static final QUser user = new QUser("user");

    public final io.brothersoo.acktion.domain.QBaseTimeStampEntity _super = new io.brothersoo.acktion.domain.QBaseTimeStampEntity(this);

    public final ListPath<UserAddress, QUserAddress> addresses = this.<UserAddress, QUserAddress>createList("addresses", UserAddress.class, QUserAddress.class, PathInits.DIRECT2);

    public final ListPath<io.brothersoo.acktion.domain.auction.AuctionRoomParticipation, io.brothersoo.acktion.domain.auction.QAuctionRoomParticipation> auctionRoomParticipations = this.<io.brothersoo.acktion.domain.auction.AuctionRoomParticipation, io.brothersoo.acktion.domain.auction.QAuctionRoomParticipation>createList("auctionRoomParticipations", io.brothersoo.acktion.domain.auction.AuctionRoomParticipation.class, io.brothersoo.acktion.domain.auction.QAuctionRoomParticipation.class, PathInits.DIRECT2);

    public final ListPath<io.brothersoo.acktion.domain.auction.SuccessfulAuctionProduct, io.brothersoo.acktion.domain.auction.QSuccessfulAuctionProduct> boughtProducts = this.<io.brothersoo.acktion.domain.auction.SuccessfulAuctionProduct, io.brothersoo.acktion.domain.auction.QSuccessfulAuctionProduct>createList("boughtProducts", io.brothersoo.acktion.domain.auction.SuccessfulAuctionProduct.class, io.brothersoo.acktion.domain.auction.QSuccessfulAuctionProduct.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final ListPath<io.brothersoo.acktion.domain.auction.SuccessfulAuctionProduct, io.brothersoo.acktion.domain.auction.QSuccessfulAuctionProduct> soldProducts = this.<io.brothersoo.acktion.domain.auction.SuccessfulAuctionProduct, io.brothersoo.acktion.domain.auction.QSuccessfulAuctionProduct>createList("soldProducts", io.brothersoo.acktion.domain.auction.SuccessfulAuctionProduct.class, io.brothersoo.acktion.domain.auction.QSuccessfulAuctionProduct.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath username = createString("username");

    public final ListPath<io.brothersoo.acktion.domain.auth.UserRole, io.brothersoo.acktion.domain.auth.QUserRole> userRoles = this.<io.brothersoo.acktion.domain.auth.UserRole, io.brothersoo.acktion.domain.auth.QUserRole>createList("userRoles", io.brothersoo.acktion.domain.auth.UserRole.class, io.brothersoo.acktion.domain.auth.QUserRole.class, PathInits.DIRECT2);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

