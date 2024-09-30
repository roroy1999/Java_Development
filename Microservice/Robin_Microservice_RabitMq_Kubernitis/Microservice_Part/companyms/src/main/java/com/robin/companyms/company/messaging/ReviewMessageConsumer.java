package com.robin.companyms.company.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.robin.companyms.company.CompanyService;
import com.robin.companyms.company.dto.ReviewMessage;

@Service
public class ReviewMessageConsumer {
	private final CompanyService companyService;

	public ReviewMessageConsumer(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
	
	@RabbitListener(queues="companyRatingQueue")
	public void consumeMessage(ReviewMessage reviewMessage) {
		companyService.updatedCompany(reviewMessage);
	}
}
