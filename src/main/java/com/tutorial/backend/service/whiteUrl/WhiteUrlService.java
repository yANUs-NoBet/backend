package com.tutorial.backend.service.whiteUrl;

import com.tutorial.backend.entity.Member;
import com.tutorial.backend.entity.WhiteUrl;

import java.util.List;

public interface WhiteUrlService {
    List<WhiteUrl> getWhiteUrls(Long id);
    WhiteUrl putNewWhiteUrl(String newUrl, Member member);
}
