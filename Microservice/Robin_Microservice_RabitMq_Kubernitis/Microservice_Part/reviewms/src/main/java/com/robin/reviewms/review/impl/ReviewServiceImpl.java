package com.robin.reviewms.review.impl;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.robin.reviewms.review.Review;
import com.robin.reviewms.review.ReviewRepository;
import com.robin.reviewms.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	private final ReviewRepository reviewRepository;
	
	public ReviewServiceImpl(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}

	@Override
	public List<Review> getAllReviews(Long CompanyId) {
		// TODO Auto-generated method stub
		List<Review> reviews = reviewRepository.findByCompanyId(CompanyId);
		return reviews;
	}

	@Override
	public boolean addReview(Long companyId, Review review) {
		if(companyId !=null && review !=null) {
			review.setCompanyId(companyId);
			reviewRepository.save(review);
			return true;
		}
		return false;
	}

	@Override
	public Review getReview(Long reviewId) {
		// TODO Auto-generated method stub
		return reviewRepository.findById(reviewId).orElse(null);
		
	}

	@Override
	public boolean updateReview(Long reviewId, Review updatedReview) {
		// TODO Auto-generated method stub
		Review review = reviewRepository.findById(reviewId).orElse(null);
		if(review!=null) {
			review.setTitle(updatedReview.getTitle());
			review.setDesciption(updatedReview.getDesciption());
			review.setRating(updatedReview.getRating());
			review.setCompanyId(updatedReview.getCompanyId());
			reviewRepository.save(review);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteReview(Long reviewId) {
		// TODO Auto-generated method stub
		Review review = reviewRepository.findById(reviewId).orElse(null);
		if(review!=null) {
			reviewRepository.delete(review);
			return true;
		}
		return false;
	}

}
