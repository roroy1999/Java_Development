package com.robin.fraud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/fraud-check")
@Slf4j
public class FraudController {
	
	private final FraudCheckService fraudCheckService;
	
	// or we can use AllArgsConstructer
	public FraudController(FraudCheckService fraudCheckService) {
		this.fraudCheckService = fraudCheckService;
	}

	@GetMapping(path = "{customerId}")
	public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
		boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
		log.info("fraud check request for customer {}", customerId);
		return new FraudCheckResponse(isFraudulentCustomer);
	}
}
