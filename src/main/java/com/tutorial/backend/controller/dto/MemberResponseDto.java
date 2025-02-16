package com.tutorial.backend.controller.dto;

import com.tutorial.backend.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDto {
    private String memberEmail;

    public static MemberResponseDto of(Member member) {
        return new MemberResponseDto(member.getMemberEmail());
    }
}
