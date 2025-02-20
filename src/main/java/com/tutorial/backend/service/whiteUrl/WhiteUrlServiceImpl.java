package com.tutorial.backend.service.whiteUrl;

import com.tutorial.backend.entity.Member;
import com.tutorial.backend.entity.WhiteUrl;
import com.tutorial.backend.repository.whiteUrl.WhiteUrlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WhiteUrlServiceImpl implements WhiteUrlService{

    private final WhiteUrlRepository whiteUrlRepository;


    @Override
    public List<WhiteUrl> getWhiteUrls(Long id) {
        return whiteUrlRepository.getListByMemberId(id);
    }

    @Override
    public WhiteUrl putNewWhiteUrl(String newUrl, Member member) {
        WhiteUrl whiteUrl = WhiteUrl.builder()
                .whiteUrl(newUrl)
                .member(member).build();

        return whiteUrlRepository.save(whiteUrl);
    }

    @Override
    public WhiteUrl deleteWhiteUrl(String whiteUrl, Member member) {
        WhiteUrl whiteUrlEntity = WhiteUrl.builder()
                .whiteUrl(whiteUrl)
                .member(member).build();
        whiteUrlRepository.delete(whiteUrlEntity);
        return whiteUrlEntity;
    }
}
