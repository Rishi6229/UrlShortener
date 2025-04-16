package com.example.urlshortener.controller;

import com.example.urlshortener.model.UrlMapping;
import com.example.urlshortener.repository.UrlMappingRepository;
import com.example.urlshortener.service.UrlShortenerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UrlShortenerController {
    private final UrlShortenerService service;
    private final UrlMappingRepository repository;

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody Map<String , String>request){
        String longUrl = request.get("url");
        String shortCode = service.shortenUrl(longUrl);
        String shortUrl = "http://localhost:8080/"+shortCode;
        return ResponseEntity.ok(shortUrl);
    }


    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortCode){
        Optional<UrlMapping> optionalMapping = repository.findById(shortCode);

        if(optionalMapping.isPresent()){
          UrlMapping mapping = optionalMapping.get();
          HttpHeaders headers = new HttpHeaders();
          headers.setLocation(URI.create(mapping.getOriginalUrl()));
          return new ResponseEntity<>(headers , HttpStatus.FOUND);

        }else{
            return ResponseEntity.notFound().build();
        }

    }


}
