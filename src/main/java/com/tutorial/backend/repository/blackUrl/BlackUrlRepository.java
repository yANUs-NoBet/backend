package com.tutorial.backend.repository.blackUrl;

import com.tutorial.backend.entity.BlackUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackUrlRepository  extends JpaRepository<BlackUrl, Long> {
}
