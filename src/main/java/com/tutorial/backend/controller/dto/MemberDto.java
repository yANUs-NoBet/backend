package com.tutorial.backend.controller.dto;


import com.tutorial.backend.entity.type.Authority;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Authority authority;
    private String profileUrl;

}
