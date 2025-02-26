package com.tutorial.backend.repository.whiteUrl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tutorial.backend.controller.dto.WhiteUrlDto;
import com.tutorial.backend.entity.QWhiteUrl;
import com.tutorial.backend.entity.QMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class WhiteUrlQueryDSLImpl implements WhiteUrlQueryDSL {

    private final JPAQueryFactory query;

    @Override
    public List<WhiteUrlDto> findWhiteUrlsByMemberId(Long memberId) {
        QWhiteUrl whiteUrl = QWhiteUrl.whiteUrl1;

        return query.selectFrom(whiteUrl)
                .where(whiteUrl.member.id.eq(memberId))  // ✅ memberId로 필터링
                .fetch()
                .stream()
                .map(w -> new WhiteUrlDto(
                        w.getId(),
                        w.getWhiteUrl(),
                        w.getMember().getId() // ✅ getMember() 대신 ID만 반환
                ))
                .collect(Collectors.toList());
    }

}
