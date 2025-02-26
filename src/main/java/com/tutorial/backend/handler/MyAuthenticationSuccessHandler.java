package com.tutorial.backend.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Slf4j
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final String REDIRECT_URI = "/oauth2/loginInfo";


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        Object principal = authentication.getPrincipal();
        if (principal instanceof OAuth2User) {

            OAuth2User oAuth2User = (OAuth2User) principal;
            String email = oAuth2User.getAttribute("email");
            String name = oAuth2User.getAttribute("name");
            Map<String, Object> attributes = oAuth2User.getAttributes();
            Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
            Map<String, Object> profile = (Map<String, Object>) kakaoAccount.get("profile");

            System.out.println("SuccessHandler oAuth2User: " + oAuth2User);
            String redirectUrl = UriComponentsBuilder.fromUriString(REDIRECT_URI)
                    .queryParam("email", email)
                    .queryParam("name",name)
                    .build()
                    .encode(StandardCharsets.UTF_8)
                    .toUriString();

            log.info(redirectUrl);
            response.sendRedirect(redirectUrl);

        } else {
            throw new IllegalStateException("Authentication principal is not an instance of OAuth2User");
        }
    }
}
