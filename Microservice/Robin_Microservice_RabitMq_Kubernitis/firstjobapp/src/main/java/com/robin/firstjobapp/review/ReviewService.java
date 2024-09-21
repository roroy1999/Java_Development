package com.robin.firstjobapp.review;

import java.util.List;

public interface ReviewService {

	List<Review> getAllReviews(Long CompanyId);
	
	boolean addReview(Long companyId, Review review);
	
	Review getReview(Long companyId, Long reviewId);
}
