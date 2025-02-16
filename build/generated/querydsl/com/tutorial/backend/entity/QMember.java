package com.tutorial.backend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 934286536L;

    public static final QMember member = new QMember("member1");

    public final EnumPath<com.tutorial.backend.entity.type.Authority> authority = createEnum("authority", com.tutorial.backend.entity.type.Authority.class);

    public final ListPath<BlackUrl, QBlackUrl> blackUrls = this.<BlackUrl, QBlackUrl>createList("blackUrls", BlackUrl.class, QBlackUrl.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath memberEmail = createString("memberEmail");

    public final StringPath memberName = createString("memberName");

    public final StringPath profileImageUrl = createString("profileImageUrl");

    public final EnumPath<com.tutorial.backend.entity.type.StatusType> status = createEnum("status", com.tutorial.backend.entity.type.StatusType.class);

    public final ListPath<WhiteUrl, QWhiteUrl> whiteUrls = this.<WhiteUrl, QWhiteUrl>createList("whiteUrls", WhiteUrl.class, QWhiteUrl.class, PathInits.DIRECT2);

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

