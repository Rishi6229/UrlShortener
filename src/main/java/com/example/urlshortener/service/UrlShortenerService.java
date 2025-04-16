package com.example.urlshortener.service;

import com.example.urlshortener.model.UrlMapping;
import com.example.urlshortener.repository.UrlMappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UrlShortenerService {
    private final UrlMappingRepository repository;

    public String shortenUrl(String originalUrl){
        Optional<UrlMapping> existing = repository.findByOriginalUrl(originalUrl);
        if(existing.isPresent()){
            return existing.get().getId();
        }


        String shortCode = generateShortCode();
        UrlMapping mapping = new UrlMapping(
                shortCode,
                originalUrl,
                LocalDateTime.now(),
                null,
                0
        );

        repository.save(mapping);
        return shortCode;

    }

    private String generateShortCode(){
        return UUID.randomUUID().toString().replace("-" , "").substring(0 , 6);
    }
}
