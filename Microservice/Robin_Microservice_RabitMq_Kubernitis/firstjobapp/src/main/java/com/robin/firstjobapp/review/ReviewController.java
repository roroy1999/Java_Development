package com.robin.firstjobapp.review;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies/{CompanyId}")
public class ReviewController {
	private ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long CompanyId){
		return new ResponseEntity<List<Review>>(reviewService.getAllReviews(CompanyId),HttpStatus.OK);
	}
	
	@PostMapping("/reviews")
	public ResponseEntity<String> addReview(@PathVariable Long CompanyId, @RequestBody Review review){
		boolean isReviewSaved = reviewService.addReview(CompanyId, review);
		if(isReviewSaved) {
			return new ResponseEntity<>("Review added Successfully",HttpStatus.OK);
		}
		return new ResponseEntity<>("Review Not Saved",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/reviews/{reviewId}")
	public ResponseEntity<Review> getReview(@PathVariable Long CompanyId,@PathVariable Long reviewId){
		return new ResponseEntity<>(reviewService.getReview(CompanyId, reviewId),HttpStatus.OK);
	}
}
