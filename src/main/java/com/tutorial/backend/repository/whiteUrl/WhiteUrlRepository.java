package com.tutorial.backend.repository.whiteUrl;

import com.tutorial.backend.entity.WhiteUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiteUrlRepository   extends JpaRepository<WhiteUrl, Long> {

    List<WhiteUrl> getListByMemberId(Long id);
}
