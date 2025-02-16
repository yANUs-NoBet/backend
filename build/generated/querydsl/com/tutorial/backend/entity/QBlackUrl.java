package com.tutorial.backend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBlackUrl is a Querydsl query type for BlackUrl
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBlackUrl extends EntityPathBase<BlackUrl> {

    private static final long serialVersionUID = -214761570L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBlackUrl blackUrl1 = new QBlackUrl("blackUrl1");

    public final StringPath blackUrl = createString("blackUrl");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public QBlackUrl(String variable) {
        this(BlackUrl.class, forVariable(variable), INITS);
    }

    public QBlackUrl(Path<? extends BlackUrl> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBlackUrl(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBlackUrl(PathMetadata metadata, PathInits inits) {
        this(BlackUrl.class, metadata, inits);
    }

    public QBlackUrl(Class<? extends BlackUrl> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

