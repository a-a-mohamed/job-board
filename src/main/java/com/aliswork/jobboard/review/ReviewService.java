package com.aliswork.jobboard.review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll();
    Review findReview(Long id);
    void createReview(Review review);
    boolean updateReview(Long id, Review updatedReview);
    boolean deleteReview(Long id);
}
