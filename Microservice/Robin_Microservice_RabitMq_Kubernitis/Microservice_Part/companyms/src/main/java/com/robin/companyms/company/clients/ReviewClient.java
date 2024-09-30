package com.robin.companyms.company.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("REVIEW-SERVICE")
public interface ReviewClient {
	
	@GetMapping("/reviews/averageRating")
	public Double getAverageRatingForCompany(@RequestParam Long CompanyId);

}
