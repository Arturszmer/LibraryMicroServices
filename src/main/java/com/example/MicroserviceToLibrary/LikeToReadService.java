package com.example.MicroserviceToLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@Component
public class LikeToReadService {

    RestTemplate restTemplate;

    public LikeToReadService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    void addReview(String title, Review review){
        String url = "http://localhost:8080/liketoread/addreview/";
//        Map<String, String> params = new HashMap<>();
//        params.put("title", title);
//        URI uri = UriComponentsBuilder.fromUriString(url)
//                .buildAndExpand(params).toUri();
        HttpEntity<Review> forEntity = new HttpEntity<>(review, null);
        restTemplate.postForEntity(url + title, forEntity, Void.class);
    }

    List<Review> getReview(String title){
        String url = "http://localhost:8080/liketoread/getreviews";
        URI uri = UriComponentsBuilder.fromHttpUrl(url).queryParam("title", title).build().toUri();
        ResponseEntity<Review[]> forEntity = restTemplate.getForEntity(uri, Review[].class);
        return Arrays.asList(Objects.requireNonNull(forEntity.getBody()));
    }

    List<Book> getBooks(){
        String url = "http://localhost:8080/liketoread/getBooks";
        ResponseEntity<Book[]> forEntity = restTemplate.getForEntity(url, Book[].class);
        return Arrays.asList(Objects.requireNonNull(forEntity.getBody()));
    }



}
