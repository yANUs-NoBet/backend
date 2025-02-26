package com.tutorial.backend.controller;

import com.tutorial.backend.controller.dto.BlackUrlDto;
import com.tutorial.backend.controller.dto.ResultDto;
import com.tutorial.backend.entity.BlackUrl;
import com.tutorial.backend.service.blackUrl.BlackUrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blackUrls/*")
@Slf4j
public class BlackUrlController {

    private final BlackUrlService blackUrlService;

    @GetMapping("getBlackUrls")
    public ResponseEntity<ResultDto<Page<BlackUrlDto>>> getBlackUrls(
            @RequestParam(defaultValue = "0") int page, // 페이지 번호 (기본값 0)
            @RequestParam(defaultValue = "20") int size // 한 페이지에 가져올 개수 (기본값 20)
    ) {
        Page<BlackUrlDto> blackUrls = blackUrlService.getBlackUrls(page, size);
        return ResponseEntity.ok().body(ResultDto.res(HttpStatus.OK, "정보를 불러왔습니다!", blackUrls));
    }


    @PostMapping("isBlackUrl")
    public ResponseEntity<ResultDto<Boolean>> isBlackUrl(@RequestBody Map<String, String> request) {
        String url = request.get("url"); // JSON 데이터에서 "url" 키의 값을 가져옴

        Optional<BlackUrl> blackUrl = blackUrlService.isBlackUrl(url);

        log.info(String.valueOf(blackUrl.isPresent()));
        return ResponseEntity.ok().body(ResultDto.res(HttpStatus.ACCEPTED, "정보를 불러왔습니다!", blackUrl.isPresent()));
    }



}
