package io.brothersoo.acktion.domain.auction;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAuctionProduct is a Querydsl query type for AuctionProduct
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAuctionProduct extends EntityPathBase<AuctionProduct> {

    private static final long serialVersionUID = -1753231203L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAuctionProduct auctionProduct = new QAuctionProduct("auctionProduct");

    public final io.brothersoo.acktion.domain.QBaseTimeStampEntity _super = new io.brothersoo.acktion.domain.QBaseTimeStampEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final io.brothersoo.acktion.domain.user.QUser owner;

    public final NumberPath<Long> startingPrice = createNumber("startingPrice", Long.class);

    public final EnumPath<AuctionProductStatus> status = createEnum("status", AuctionProductStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAuctionProduct(String variable) {
        this(AuctionProduct.class, forVariable(variable), INITS);
    }

    public QAuctionProduct(Path<? extends AuctionProduct> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAuctionProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAuctionProduct(PathMetadata metadata, PathInits inits) {
        this(AuctionProduct.class, metadata, inits);
    }

    public QAuctionProduct(Class<? extends AuctionProduct> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.owner = inits.isInitialized("owner") ? new io.brothersoo.acktion.domain.user.QUser(forProperty("owner")) : null;
    }

}

