package com.tutorial.backend.service.member;

import com.tutorial.backend.controller.dto.JoinForm;
import com.tutorial.backend.entity.Member;

import java.util.Optional;

public interface MemberService {
    Optional<Member> getMemberByEmail(String memberEmail);

    Member saveMember(JoinForm loginForm);


    Optional<Member> getMemberByMemberEmailAndMemberName(String memberEmail, String memberName);

    default Member toEntity(JoinForm loginForm){
        return Member.builder().memberEmail(loginForm.getEmail())
                .build();
    }

    Optional<Member> getMemberById(Long id);
}
