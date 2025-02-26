package com.tutorial.backend.repository.whiteUrl;

import com.tutorial.backend.controller.dto.WhiteUrlDto;
import java.util.List;

public interface WhiteUrlQueryDSL {
    List<WhiteUrlDto> findWhiteUrlsByMemberId(Long memberId);
}
