package com.tutorial.backend.controller;

import com.tutorial.backend.controller.dto.ResultDto;
import com.tutorial.backend.entity.BlackUrl;
import com.tutorial.backend.entity.WhiteUrl;
import com.tutorial.backend.provider.MemberDetail;
import com.tutorial.backend.service.blackUrl.BlackUrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/urls/*")
@Slf4j
public class BlackUrlController {

    private final BlackUrlService blackUrlService;

    @GetMapping("getWhiteUrls")
    private ResponseEntity<ResultDto<List<BlackUrl>>> getWhiteUrls(){
        List<BlackUrl> blackUrls= blackUrlService.getBlackUrls();
        return ResponseEntity.ok().body(ResultDto.res(HttpStatus.ACCEPTED,"정보를 불러왔습니다!",blackUrls));
    }

}
