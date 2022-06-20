package io.brothersoo.acktion.domain.auth;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPrivilege is a Querydsl query type for Privilege
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPrivilege extends EntityPathBase<Privilege> {

    private static final long serialVersionUID = 2116481041L;

    public static final QPrivilege privilege = new QPrivilege("privilege");

    public final io.brothersoo.acktion.domain.QBaseTimeStampEntity _super = new io.brothersoo.acktion.domain.QBaseTimeStampEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QPrivilege(String variable) {
        super(Privilege.class, forVariable(variable));
    }

    public QPrivilege(Path<? extends Privilege> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPrivilege(PathMetadata metadata) {
        super(Privilege.class, metadata);
    }

}

