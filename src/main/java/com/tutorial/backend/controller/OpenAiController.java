package com.tutorial.backend.controller;

import com.tutorial.backend.controller.dto.ResultDto;
import com.tutorial.backend.service.openAi.OpenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/openai")
@RequiredArgsConstructor
public class OpenAiController {

    private final OpenAiService openAiService;

    //✅ 웹사이트 내부 텍스트를 분석하여 도박 사이트 여부 판단
    @PostMapping("/analyze")
    public ResponseEntity<ResultDto<Boolean>> analyzeGamblingContent(@RequestBody String textContent) {
        try {
            boolean isGambling = openAiService.isGamblingContent(textContent);
            return ResponseEntity.ok(ResultDto.res(HttpStatus.OK, "분석 완료", isGambling));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ResultDto.res(HttpStatus.INTERNAL_SERVER_ERROR, "AI 분석 중 오류 발생", false));
        }
    }
}
