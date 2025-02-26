package com.tutorial.backend.controller.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BlackUrlDto {
    private Long id;
    private String blackUrl;
    private Long memberId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy년 MM월 dd일")
    private LocalDateTime blockedAt; // ✅ 차단된 날짜 추가

    @Builder
    public BlackUrlDto(Long id, String blackUrl, Long memberId, LocalDateTime blockedAt) {
        this.id = id;
        this.blackUrl = blackUrl;
        this.memberId = memberId;
        this.blockedAt = blockedAt;
    }
}
