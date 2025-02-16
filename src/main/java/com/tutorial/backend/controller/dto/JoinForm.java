package com.tutorial.backend.controller.dto;


import com.tutorial.backend.entity.Member;
import com.tutorial.backend.entity.type.Authority;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Getter @Setter
@ToString
@NoArgsConstructor
public class JoinForm {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String phoneNum;
    private LocalDate birth;

    @Builder
    public JoinForm(Long id,String email, String password, String name, String phoneNum, LocalDate birth ) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNum = phoneNum;
        this.birth = birth;
    }



    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .id(id)
                .memberEmail(email)
                .memberName(name)
                .authority(Authority.USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
