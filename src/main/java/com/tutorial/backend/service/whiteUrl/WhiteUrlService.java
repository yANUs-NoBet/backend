package com.tutorial.backend.service.whiteUrl;

import com.tutorial.backend.controller.dto.WhiteUrlDto;
import com.tutorial.backend.entity.Member;
import com.tutorial.backend.entity.WhiteUrl;

import java.util.List;
import java.util.Optional;

public interface WhiteUrlService {
    List<WhiteUrlDto> getWhiteUrls(Long id);
    WhiteUrl putNewWhiteUrl(String newUrl, Member member);

    WhiteUrl deleteWhiteUrl(String whiteUrl, Member member);
    Optional<WhiteUrl> getWhiteUrlOrNot(String url, Member member);
}
