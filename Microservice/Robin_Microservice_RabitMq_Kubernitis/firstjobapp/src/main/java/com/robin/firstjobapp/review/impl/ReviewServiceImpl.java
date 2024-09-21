package com.robin.firstjobapp.review.impl;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.robin.firstjobapp.company.Company;
import com.robin.firstjobapp.company.CompanyService;
import com.robin.firstjobapp.review.Review;
import com.robin.firstjobapp.review.ReviewRepository;
import com.robin.firstjobapp.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	private final ReviewRepository reviewRepository;
	private final CompanyService companyService;
	
	public ReviewServiceImpl(ReviewRepository reviewRepository,CompanyService companyService) {
		this.reviewRepository = reviewRepository;
		this.companyService = companyService;
	}

	@Override
	public List<Review> getAllReviews(Long CompanyId) {
		// TODO Auto-generated method stub
		List<Review> reviews = reviewRepository.findByCompanyId(CompanyId);
		return reviews;
	}

	@Override
	public boolean addReview(Long companyId, Review review) {
		Company company = companyService.getCompanyById(companyId);
		if(company!=null) {
			review.setCompany(company);
			reviewRepository.save(review);
			return true;
		}
		return false;
	}

	@Override
	public Review getReview(Long companyId, Long reviewId) {
		// TODO Auto-generated method stub
		List<Review> reviews = reviewRepository.findByCompanyId(companyId);
		return reviews.stream().filter(review->review.getId().equals(reviewId)).findFirst().orElse(null);
	}

	@Override
	public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
		// TODO Auto-generated method stub
		if(companyService.getCompanyById(companyId)!=null) {
			updatedReview.setCompany(companyService.getCompanyById(companyId));
			updatedReview.setId(reviewId);
			reviewRepository.save(updatedReview);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteReview(Long companyId, Long reviewId) {
		// TODO Auto-generated method stub
		if(companyService.getCompanyById(companyId)!=null && reviewRepository.existsById(reviewId)) {
			Review review = reviewRepository.findById(reviewId).orElse(null);
			Company company = review.getCompany();
			company.getReviews().remove(review);
			companyService.updatedCompany(company, companyId);
			review.setCompany(null);
			reviewRepository.deleteById(reviewId);
			return true;
		}
		return false;
	}

}
