package com.tutorial.backend.service.blackUrl;

import com.tutorial.backend.entity.BlackUrl;
import com.tutorial.backend.repository.blackUrl.BlackUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlackUrlServiceImpl implements BlackUrlService{

    private final BlackUrlRepository blackUrlRepository;

    @Override
    public List<BlackUrl> getBlackUrls() {
        return blackUrlRepository.findAll();
    }
}
