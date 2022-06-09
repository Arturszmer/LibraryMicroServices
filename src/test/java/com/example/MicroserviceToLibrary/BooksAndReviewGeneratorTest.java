package com.example.MicroserviceToLibrary;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class BooksAndReviewGeneratorTest {

    @Autowired
    BooksAndReviewGenerator booksAndReviewGenerator;

    @Test
    public void showString(){
        booksAndReviewGenerator.generateReviews();
    }
}
