package com.tutorial.backend.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_black_url")
@ToString
public class BlackUrl {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "black_url", nullable = false, length = 50)
    private String blackUrl;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Builder
    public BlackUrl(Long id, String blackUrl, Member member) {
        this.id = id;
        this.blackUrl = blackUrl;
        this.member = member;
    }
}
