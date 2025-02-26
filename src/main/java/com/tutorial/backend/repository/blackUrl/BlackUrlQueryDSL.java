package com.tutorial.backend.repository.blackUrl;

import com.tutorial.backend.controller.dto.BlackUrlDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlackUrlQueryDSL {
    Page<BlackUrlDto> getBlackUrls(Pageable pageable);
}
