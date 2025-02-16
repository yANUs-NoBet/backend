package com.tutorial.backend.controller.dto;

import com.tutorial.backend.entity.Member;
import com.tutorial.backend.entity.type.Authority;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {

    private String memberEmail;
    private String memberPassword;

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .memberEmail(memberEmail)
                .authority(Authority.USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(memberEmail, memberPassword);
    }
}
