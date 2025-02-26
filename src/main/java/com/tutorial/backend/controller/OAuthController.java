package com.tutorial.backend.controller;

import com.tutorial.backend.controller.dto.TokenDto;
import com.tutorial.backend.service.auth.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
@RequestMapping("/oauth2/*")
@Slf4j
public class OAuthController {


    private final AuthServiceImpl authServiceImpl;

    private static final String REDIRECT_URI = "chrome-extension://aifenekmnojhkbgjbkbpoinlmclppkii/index.html#/oauth";

    @GetMapping("loginInfo")
    public void onAuthenticationSuccess(HttpServletResponse response,
                                        @RequestParam String email,
                                        @RequestParam String name) throws IOException {
        log.info("들어옴");
        // 토큰 발행
        TokenDto tokenDto = authServiceImpl.socialLogin(email, name);
        String accessToken = tokenDto.getAccessToken();
        String refreshToken = tokenDto.getRefreshToken();
        Long accessTokenExpiresIn = tokenDto.getAccessTokenExpiresIn();

        log.info("들어옴");

        // ✅ UriComponentsBuilder 대신 직접 URL 조합
        String redirectUrl = String.format("%s?accessToken=%s&refreshToken=%s&accessTokenExpiresIn=%d",
                REDIRECT_URI, accessToken, refreshToken, accessTokenExpiresIn);

        response.sendRedirect(redirectUrl);
    }

}
