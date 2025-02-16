package com.tutorial.backend.controller.dto;

import com.tutorial.backend.entity.Member;
import com.tutorial.backend.entity.type.StatusType;
import com.tutorial.backend.entity.type.Authority;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberProfile {
    private String name;
    private String email;
    private String phoneNum;
    private String profileImageUrl; // 프로필 이미지 URL 필드 추가

    // toMember 메서드 수정
    public Member toMember() {
        return Member.builder()
                .memberName(name)
                .memberEmail(email)
                .profileImageUrl(profileImageUrl) // 추가
                .status(StatusType.ABLE)
                .authority(Authority.USER)
                .build();
    }
}
