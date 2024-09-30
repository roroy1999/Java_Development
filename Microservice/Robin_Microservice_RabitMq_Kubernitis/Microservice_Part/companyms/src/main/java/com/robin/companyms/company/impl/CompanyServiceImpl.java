package com.robin.companyms.company.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.robin.companyms.company.Company;
import com.robin.companyms.company.CompanyRepository;
import com.robin.companyms.company.CompanyService;
import com.robin.companyms.company.clients.ReviewClient;
//import com.robin.firstjobapp.job.Job;
import com.robin.companyms.company.dto.ReviewMessage;

import jakarta.ws.rs.NotFoundException;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	private CompanyRepository companyRepository;
	private ReviewClient reviewClient;
	
	public CompanyServiceImpl(CompanyRepository companyRepository,ReviewClient reviewClient) {
		super();
		this.companyRepository = companyRepository;
		this.reviewClient = reviewClient;
	}

	@Override
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

	@Override
	public boolean updatedCompany(Company company, Long id) {
		Optional<Company> companyOption = companyRepository.findById(id);
		// TODO Auto-generated method stub
		
			if(companyOption.isPresent()) {
				
				Company companyToUpdate = companyOption.get();
				companyToUpdate.setName(company.getName());
				companyToUpdate.setDescription(company.getDescription());
				//companyToUpdate.setJobs(company.getJobs());
				
				companyRepository.save(companyToUpdate);
				return true;
			}
		return false;
	}

	@Override
	public void createCompany(Company company) {
		
		companyRepository.save(company);
		
	}

	@Override
	public boolean deleteCompanyById(Long id) {
		// TODO Auto-generated method stub
		if(companyRepository.existsById(id)) {
			
			companyRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Company getCompanyById(Long id) {
		// TODO Auto-generated method stub
		return companyRepository.findById(id).orElse(null);
	}

	@Override
	public void updatedCompany(ReviewMessage reviewMessage) {
		// TODO Auto-generated method stub
		System.out.println(reviewMessage.getDescription());
		Company company = companyRepository.findById(reviewMessage.getCompanyId()).orElseThrow(()-> new NotFoundException("Company not Found : "+reviewMessage.getCompanyId()));
		
		Double averageRating = reviewClient.getAverageRatingForCompany(reviewMessage.getCompanyId());
		company.setRating(averageRating);
		companyRepository.save(company);
	}
	
}
