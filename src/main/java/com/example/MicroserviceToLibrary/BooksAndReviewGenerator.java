package com.example.MicroserviceToLibrary;

import jdk.jfr.Threshold;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class BooksAndReviewGenerator {

    @Autowired
    LikeToReadService service;

    public BooksAndReviewGenerator(LikeToReadService service) {
        this.service = service;
    }

    @Scheduled (fixedRate = 5000)
    public void generateReviews(){
        Random random = new Random();
        int index = random.nextInt(0, service.getBooks().size());
        Book book = service.getBooks().get(index);
        String title = book.getTitle();
        service.addReview(title, randomReview());
    }

    @Scheduled(fixedRate = 20000)
    public List<Review> getAllReviews(){
        List<Book> books = service.getBooks();
        List<Review> list = books.stream()
                .map(Book::getReviews).toList()
                .stream().flatMap(List::stream)
                .collect(Collectors.toList());
        for (Review review : list){
            System.out.println(review);
        }
        return list;
    }

    public String generateRandomString(int lenght){

        return RandomStringUtils.randomAlphabetic(lenght);
    }

    public Review randomReview(){
        Random random = new Random();
        List<Score> enumList = new ArrayList<>();
        enumList.add(Score.BAD);
        enumList.add(Score.GOOD);
        enumList.add(Score.EXCELLENT);

        return new Review(generateRandomString(6), enumList.get(random.nextInt(2)), generateRandomString(20));
    }



}
