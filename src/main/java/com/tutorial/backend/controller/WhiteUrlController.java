package com.tutorial.backend.controller;

import com.tutorial.backend.controller.dto.ResultDto;
import com.tutorial.backend.entity.WhiteUrl;
import com.tutorial.backend.provider.MemberDetail;
import com.tutorial.backend.service.whiteUrl.WhiteUrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/whiteUrls/*")
@Slf4j
public class WhiteUrlController {

    private final WhiteUrlService whiteUrlService;

    @GetMapping("getWhiteUrls")
    private ResponseEntity<ResultDto<List<WhiteUrl>>> getWhiteUrls(Authentication authentication){
        MemberDetail memberDetail= (MemberDetail)authentication.getPrincipal();
        List<WhiteUrl> whiteUrls= whiteUrlService.getWhiteUrls(memberDetail.getId());
        return ResponseEntity.ok().body(ResultDto.res(HttpStatus.ACCEPTED,"정보를 불러왔습니다!",whiteUrls));
    }

    @PostMapping("newWhiteUrls")
    private ResponseEntity<ResultDto<String>> newWhiteUrl(Authentication authentication, @RequestBody String newWhiteUrl){
        try{
            MemberDetail memberDetail = (MemberDetail) authentication.getPrincipal();
            whiteUrlService.putNewWhiteUrl(newWhiteUrl, memberDetail.getMember());
            return ResponseEntity.ok().body(ResultDto.res(HttpStatus.ACCEPTED, "정보가 입력되었습니다!"));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(ResultDto.res(HttpStatus.BAD_REQUEST,"오류가 발생했어요"));
        }

    }
    @PostMapping("deleteWhiteUrls")
    private ResponseEntity<ResultDto<String>> deleteWhiteUrl(Authentication authentication, @RequestBody String whiteUrl){
        try{
            MemberDetail memberDetail = (MemberDetail) authentication.getPrincipal();
            whiteUrlService.deleteWhiteUrl(whiteUrl, memberDetail.getMember());
            return ResponseEntity.ok().body(ResultDto.res(HttpStatus.ACCEPTED, "정보가 삭되었습니다!"));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(ResultDto.res(HttpStatus.BAD_REQUEST,"오류가 발생했어요"));
        }

    }








}
