package com.tutorial.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tutorial.backend.entity.type.Authority;
import com.tutorial.backend.entity.type.StatusType;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_member")
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "member_email")
    private String memberEmail;

    @Column(name = "member_profile_image_url")
    private String profileImageUrl;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @Column(name = "member_name")
    private String memberName;

    @Enumerated(EnumType.STRING)
    private Authority authority;


    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BlackUrl> blackUrls;  // 🚨 문제 발생 가능

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WhiteUrl> whiteUrls;  // 🔥 지연 로딩


    public Member update(String memberName, String memberEmail, String profileImageUrl){
        this.setMemberName(memberName);
        this.setMemberEmail(memberEmail);
        this.setProfileImageUrl(profileImageUrl);
        return this;
    }

    @Builder
    public Member(Long id, String memberEmail, String memberName, String profileImageUrl, StatusType status, Authority authority) {
        this.id = id;
        this.memberEmail = memberEmail;
        this.memberName = memberName;
        this.profileImageUrl = profileImageUrl;
        this.status = status;
        this.authority = authority;
    }
}
