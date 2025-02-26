package com.tutorial.backend.repository.blackUrl;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tutorial.backend.controller.dto.BlackUrlDto;
import com.tutorial.backend.entity.QBlackUrl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BlackUrlQueryDSLImpl implements BlackUrlQueryDSL {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<BlackUrlDto> getBlackUrls(Pageable pageable) {
        QBlackUrl blackUrl = QBlackUrl.blackUrl1; // ✅ QueryDSL 엔터티 객체

        // ✅ 페이징 적용하여 데이터 조회
        List<BlackUrlDto> blackUrls = queryFactory
                .select(Projections.constructor(BlackUrlDto.class,
                        blackUrl.id,
                        blackUrl.blackUrl,
                        blackUrl.member.id,
                        blackUrl.blockedAt)) // ✅ 차단된 날짜 추가
                .from(blackUrl)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();



        // 전체 데이터 개수 조회 (null 방지)
        Long total = queryFactory
                .select(blackUrl.count())
                .from(blackUrl)
                .fetchOne();

        total = (total != null) ? total : 0L; // ✅ null이면 0으로 처리


        return new PageImpl<>(blackUrls, pageable, total);
    }
}
