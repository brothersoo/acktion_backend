package io.brothersoo.acktion.domain.auction;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAuctionRoom is a Querydsl query type for AuctionRoom
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAuctionRoom extends EntityPathBase<AuctionRoom> {

    private static final long serialVersionUID = -643576851L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAuctionRoom auctionRoom = new QAuctionRoom("auctionRoom");

    public final io.brothersoo.acktion.domain.QBaseTimeStampEntity _super = new io.brothersoo.acktion.domain.QBaseTimeStampEntity(this);

    public final QAuctionProduct auctionProduct;

    public final ListPath<AuctionRoomParticipation, QAuctionRoomParticipation> auctionRoomParticipants = this.<AuctionRoomParticipation, QAuctionRoomParticipation>createList("auctionRoomParticipants", AuctionRoomParticipation.class, QAuctionRoomParticipation.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final EnumPath<AuctionRoomStatus> status = createEnum("status", AuctionRoomStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAuctionRoom(String variable) {
        this(AuctionRoom.class, forVariable(variable), INITS);
    }

    public QAuctionRoom(Path<? extends AuctionRoom> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAuctionRoom(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAuctionRoom(PathMetadata metadata, PathInits inits) {
        this(AuctionRoom.class, metadata, inits);
    }

    public QAuctionRoom(Class<? extends AuctionRoom> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.auctionProduct = inits.isInitialized("auctionProduct") ? new QAuctionProduct(forProperty("auctionProduct"), inits.get("auctionProduct")) : null;
    }

}

