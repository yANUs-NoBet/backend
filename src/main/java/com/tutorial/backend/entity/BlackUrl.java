package com.tutorial.backend.entity;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_black_url")
@ToString
public class BlackUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "black_url", nullable = false, length = 50)
    private String blackUrl;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    @JsonIgnore
    private Member member;

    @Column(name = "blocked_at", nullable = false, updatable = false)
    private LocalDateTime blockedAt; // ✅ 차단된 날짜 필드 추가

    @Builder
    public BlackUrl(Long id, String blackUrl, Member member, LocalDateTime blockedAt) {
        this.id = id;
        this.blackUrl = blackUrl;
        this.member = member;
        this.blockedAt = blockedAt != null ? blockedAt : LocalDateTime.now(); // ✅ 기본값 설정
    }
}
