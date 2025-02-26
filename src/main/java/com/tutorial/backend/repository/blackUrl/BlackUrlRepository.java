package com.tutorial.backend.repository.blackUrl;

import com.tutorial.backend.entity.BlackUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlackUrlRepository  extends JpaRepository<BlackUrl, Long> {
    BlackUrl findByBlackUrl(String url);
}
