package com.tutorial.backend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWhiteUrl is a Querydsl query type for WhiteUrl
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWhiteUrl extends EntityPathBase<WhiteUrl> {

    private static final long serialVersionUID = -1280943308L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWhiteUrl whiteUrl1 = new QWhiteUrl("whiteUrl1");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public final StringPath whiteUrl = createString("whiteUrl");

    public QWhiteUrl(String variable) {
        this(WhiteUrl.class, forVariable(variable), INITS);
    }

    public QWhiteUrl(Path<? extends WhiteUrl> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWhiteUrl(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWhiteUrl(PathMetadata metadata, PathInits inits) {
        this(WhiteUrl.class, metadata, inits);
    }

    public QWhiteUrl(Class<? extends WhiteUrl> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

