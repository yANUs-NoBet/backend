package com.tutorial.backend.service.blackUrl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tutorial.backend.controller.dto.BlackUrlDto;
import com.tutorial.backend.entity.BlackUrl;
import com.tutorial.backend.entity.QBlackUrl;
import com.tutorial.backend.repository.blackUrl.BlackUrlQueryDSL;
import com.tutorial.backend.repository.blackUrl.BlackUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlackUrlServiceImpl implements BlackUrlService{

    private final BlackUrlRepository blackUrlRepository;


    private final BlackUrlQueryDSL blackUrlQueryDSL; // ✅ QueryDSL 인터페이스 주입

    @Override
    public Page<BlackUrlDto> getBlackUrls(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return blackUrlQueryDSL.getBlackUrls(pageable); // ✅ QueryDSL 호출
    }
    @Override
    public Optional<BlackUrl> isBlackUrl(String url) {
        return Optional.ofNullable(blackUrlRepository.findByBlackUrl(url));
    }
}
