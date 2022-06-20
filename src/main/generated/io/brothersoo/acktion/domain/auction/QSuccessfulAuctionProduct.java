package io.brothersoo.acktion.domain.auction;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSuccessfulAuctionProduct is a Querydsl query type for SuccessfulAuctionProduct
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSuccessfulAuctionProduct extends EntityPathBase<SuccessfulAuctionProduct> {

    private static final long serialVersionUID = 183097495L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSuccessfulAuctionProduct successfulAuctionProduct = new QSuccessfulAuctionProduct("successfulAuctionProduct");

    public final io.brothersoo.acktion.domain.QBaseTimeStampEntity _super = new io.brothersoo.acktion.domain.QBaseTimeStampEntity(this);

    public final QAuctionProduct auctionProduct;

    public final io.brothersoo.acktion.domain.user.QUser bidder;

    public final StringPath bidderName = createString("bidderName");

    public final io.brothersoo.acktion.domain.user.QUser cosigner;

    public final StringPath cosignerName = createString("cosignerName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> hammerPrice = createNumber("hammerPrice", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QSuccessfulAuctionProduct(String variable) {
        this(SuccessfulAuctionProduct.class, forVariable(variable), INITS);
    }

    public QSuccessfulAuctionProduct(Path<? extends SuccessfulAuctionProduct> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSuccessfulAuctionProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSuccessfulAuctionProduct(PathMetadata metadata, PathInits inits) {
        this(SuccessfulAuctionProduct.class, metadata, inits);
    }

    public QSuccessfulAuctionProduct(Class<? extends SuccessfulAuctionProduct> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.auctionProduct = inits.isInitialized("auctionProduct") ? new QAuctionProduct(forProperty("auctionProduct"), inits.get("auctionProduct")) : null;
        this.bidder = inits.isInitialized("bidder") ? new io.brothersoo.acktion.domain.user.QUser(forProperty("bidder")) : null;
        this.cosigner = inits.isInitialized("cosigner") ? new io.brothersoo.acktion.domain.user.QUser(forProperty("cosigner")) : null;
    }

}

