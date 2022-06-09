package com.example.MicroserviceToLibrary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book {
    private final String title;
    private final String identifier;
    private final List<Review> reviews = new ArrayList<>();

    Book(String title, String identifier) {
        this.title = title;
        this.identifier = identifier;
    }

    public String getTitle() {
        return title;
    }

    public String getIdentifier() {
        return identifier;
    }

    void addReview(Review review) {
        reviews.add(review);
    }

    public List<Review> getReviews() {
        return Collections.unmodifiableList(reviews);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", identifier='" + identifier + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}
