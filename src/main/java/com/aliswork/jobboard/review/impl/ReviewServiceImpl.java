package com.aliswork.jobboard.review.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aliswork.jobboard.review.Review;
import com.aliswork.jobboard.review.ReviewRepository;
import com.aliswork.jobboard.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{

    ReviewRepository reviewRepository;
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findReview(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public void createReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public boolean updateReview(Long id, Review updatedReview) {
        Optional<Review> optional = reviewRepository.findById(id);
        if (optional.isPresent()){
            Review review = optional.get();
            review.setTitle(updatedReview.getTitle());
            review.setDescription(updatedReview.getDescription());
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long id) {
        try{
            reviewRepository.deleteById(id);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    
}
