package com.tutorial.backend.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_white_url")
@ToString
public class WhiteUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "white_url", nullable = false, length = 50)
    private String whiteUrl;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;


    @Builder
    public WhiteUrl(Long id, String whiteUrl, Member member) {
        this.id = id;
        this.whiteUrl = whiteUrl;
        this.member = member;
    }
}
