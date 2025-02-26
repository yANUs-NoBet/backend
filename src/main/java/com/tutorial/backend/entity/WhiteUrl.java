package com.tutorial.backend.entity;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @JsonIgnore
    private Member member;

    @Column(name = "upload_date", nullable = false, updatable = false)
    private LocalDateTime uploadDate; // ✅ 차단된 날짜 필드 추가


    @Builder
    public WhiteUrl(Long id, String whiteUrl, Member member, LocalDateTime uploadDate) {
        this.id = id;
        this.whiteUrl = whiteUrl;
        this.member = member;
        this.uploadDate = uploadDate;
    }
}
