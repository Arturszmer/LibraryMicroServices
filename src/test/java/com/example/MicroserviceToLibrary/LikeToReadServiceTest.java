package com.example.MicroserviceToLibrary;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LikeToReadServiceTest {

    @Autowired
    private LikeToReadService service;

    @Test
    public void shouldAddReview() {
        //given
        Review review = new Review("nameNick1", Score.BAD, "sdawgaeff");
        String title = "title1";

        //when
        service.addReview(title, review);

        //then
        List<Review> reviews = service.getReview("title1");
        assertThat(reviews.size()).isEqualTo(1);
        assertThat(reviews).contains(review);
    }
    @Test
    public void shouldGetUrl(){
        service.getReview("title1");
        }

    }

