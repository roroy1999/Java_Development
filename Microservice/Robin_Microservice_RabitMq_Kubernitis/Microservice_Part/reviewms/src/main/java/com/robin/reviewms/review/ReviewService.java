package com.robin.reviewms.review;

import java.util.List;

public interface ReviewService {

	List<Review> getAllReviews(Long CompanyId);
	
	boolean addReview(Long companyId, Review review);
	
	Review getReview(Long reviewId);
	
	boolean updateReview(Long reviewId,Review review);

	boolean deleteReview(Long reviewId);
}
