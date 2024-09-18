package com.robin.fraud;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class FraudCheckService {
	
	private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
	
	public FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
		this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
	}

	public boolean isFraudulentCustomer(Integer customerId) {
		fraudCheckHistoryRepository.save(FraudCheckHistory.builder().isFraudster(false).customerId(customerId).createdAt(LocalDateTime.now()).build());
		return false;
	}
}
