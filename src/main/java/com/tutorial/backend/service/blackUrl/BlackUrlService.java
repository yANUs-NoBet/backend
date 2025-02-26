package com.tutorial.backend.service.blackUrl;

import com.tutorial.backend.controller.dto.BlackUrlDto;
import com.tutorial.backend.entity.BlackUrl;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BlackUrlService {
    Page<BlackUrlDto> getBlackUrls(int page, int size);
    Optional<BlackUrl> isBlackUrl(String url);
}
