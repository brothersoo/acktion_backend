package io.brothersoo.acktion.domain.auction;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAuctionRoomParticipation is a Querydsl query type for AuctionRoomParticipation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAuctionRoomParticipation extends EntityPathBase<AuctionRoomParticipation> {

    private static final long serialVersionUID = 101874260L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAuctionRoomParticipation auctionRoomParticipation = new QAuctionRoomParticipation("auctionRoomParticipation");

    public final io.brothersoo.acktion.domain.QBaseTimeStampEntity _super = new io.brothersoo.acktion.domain.QBaseTimeStampEntity(this);

    public final QAuctionRoom auctionRoom;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final io.brothersoo.acktion.domain.user.QUser participant;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAuctionRoomParticipation(String variable) {
        this(AuctionRoomParticipation.class, forVariable(variable), INITS);
    }

    public QAuctionRoomParticipation(Path<? extends AuctionRoomParticipation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAuctionRoomParticipation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAuctionRoomParticipation(PathMetadata metadata, PathInits inits) {
        this(AuctionRoomParticipation.class, metadata, inits);
    }

    public QAuctionRoomParticipation(Class<? extends AuctionRoomParticipation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.auctionRoom = inits.isInitialized("auctionRoom") ? new QAuctionRoom(forProperty("auctionRoom"), inits.get("auctionRoom")) : null;
        this.participant = inits.isInitialized("participant") ? new io.brothersoo.acktion.domain.user.QUser(forProperty("participant")) : null;
    }

}

