package com.tutorial.backend.service.whiteUrl;

import com.tutorial.backend.controller.dto.WhiteUrlDto;
import com.tutorial.backend.entity.Member;
import com.tutorial.backend.entity.WhiteUrl;
import com.tutorial.backend.repository.whiteUrl.WhiteUrlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class WhiteUrlServiceImpl implements WhiteUrlService{

    private final WhiteUrlRepository whiteUrlRepository;


    @Override
    public List<WhiteUrlDto> getWhiteUrls(Long id) {
        return whiteUrlRepository.findWhiteUrlsByMemberId(id);
    }

    @Override
    public WhiteUrl putNewWhiteUrl(String newUrl, Member member) {
        WhiteUrl whiteUrl = WhiteUrl.builder()
                .whiteUrl(newUrl)
                .uploadDate(LocalDateTime.now())
                .member(member).build();

        return whiteUrlRepository.save(whiteUrl);
    }

    @Override
    public WhiteUrl deleteWhiteUrl(String whiteUrl, Member member) {
        WhiteUrl whiteUrlEntity = whiteUrlRepository.findByWhiteUrlAndMember(whiteUrl, member)
                .orElseThrow(() -> new IllegalArgumentException("해당 URL이 존재하지 않습니다: " + whiteUrl));

        whiteUrlRepository.delete(whiteUrlEntity);

        return whiteUrlEntity;
    }

    @Override
    public Optional<WhiteUrl> getWhiteUrlOrNot(String url, Member member) {

        return whiteUrlRepository.findByWhiteUrlAndMember(url,member);
    }
}
