package com.tutorial.backend.repository.whiteUrl;

import com.tutorial.backend.entity.Member;
import com.tutorial.backend.entity.WhiteUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WhiteUrlRepository extends JpaRepository<WhiteUrl, Long>, WhiteUrlQueryDSL{

    List<WhiteUrl> getListByMemberId(Long id);
    Optional<WhiteUrl> findByWhiteUrlAndMember(String whiteUrl, Member member);

}
