package com.tutorial.backend.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WhiteUrlDto {
    private Long id;
    private String whiteUrl;
    private Long memberId;  // ✅ Member 객체 대신 ID만 저장

    @Builder
    public WhiteUrlDto(Long id, String whiteUrl, Long memberId) {
        this.id = id;
        this.whiteUrl = whiteUrl;
        this.memberId = memberId;
    }
}

