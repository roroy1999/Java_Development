package com.robin.reviewms.review.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.robin.reviewms.review.Review;
import com.robin.reviewms.review.dto.ReviewMessage;

@Service
public class ReviewMessageProducer {
	
	private final RabbitTemplate rabbitTemplate;

	public ReviewMessageProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendMessage(Review review) {
		ReviewMessage reviewMessage =  new ReviewMessage();
		reviewMessage.setId(review.getId());
		reviewMessage.setTitle(review.getTitle());
		reviewMessage.setDescription(review.getDesciption());
		reviewMessage.setRating(review.getRating());
		reviewMessage.setCompanyId(review.getCompanyId());
		rabbitTemplate.convertAndSend("companyRatingQueue",reviewMessage);
	}
	
	

}
