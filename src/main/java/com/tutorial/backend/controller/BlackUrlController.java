package com.tutorial.backend.controller;

import com.tutorial.backend.controller.dto.ResultDto;
import com.tutorial.backend.entity.BlackUrl;
import com.tutorial.backend.service.blackUrl.BlackUrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blackUrls/*")
@Slf4j
public class BlackUrlController {

    private final BlackUrlService blackUrlService;

    @GetMapping("getBlackUrls")
    private ResponseEntity<ResultDto<List<BlackUrl>>> getBlackUrls(){
        List<BlackUrl> blackUrls= blackUrlService.getBlackUrls();
        return ResponseEntity.ok().body(ResultDto.res(HttpStatus.ACCEPTED,"정보를 불러왔습니다!",blackUrls));
    }

    @PostMapping("isBlackUrl")
    public ResponseEntity<ResultDto<Boolean>> isBlackUrl(@RequestBody Map<String, String> request) {
        String url = request.get("url"); // JSON 데이터에서 "url" 키의 값을 가져옴

        List<BlackUrl> blackUrls = blackUrlService.getBlackUrls();

        boolean isBlocked = blackUrls.stream()
                .map(BlackUrl::getBlackUrl)  // BlackUrl 객체에서 URL을 추출
                .anyMatch(blackUrl -> blackUrl.equals(url)); // 차단 목록과 비교

        return ResponseEntity.ok().body(ResultDto.res(HttpStatus.ACCEPTED, "정보를 불러왔습니다!", isBlocked));
    }



}
