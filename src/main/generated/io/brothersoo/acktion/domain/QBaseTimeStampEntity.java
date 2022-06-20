package io.brothersoo.acktion.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseTimeStampEntity is a Querydsl query type for BaseTimeStampEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBaseTimeStampEntity extends EntityPathBase<BaseTimeStampEntity> {

    private static final long serialVersionUID = 653047490L;

    public static final QBaseTimeStampEntity baseTimeStampEntity = new QBaseTimeStampEntity("baseTimeStampEntity");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QBaseTimeStampEntity(String variable) {
        super(BaseTimeStampEntity.class, forVariable(variable));
    }

    public QBaseTimeStampEntity(Path<? extends BaseTimeStampEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseTimeStampEntity(PathMetadata metadata) {
        super(BaseTimeStampEntity.class, metadata);
    }

}

