package com.robin.firstjobapp.company.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.robin.firstjobapp.company.Company;
import com.robin.firstjobapp.company.CompanyRepository;
import com.robin.firstjobapp.company.CompanyService;
import com.robin.firstjobapp.job.Job;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	private CompanyRepository companyRepository;
	
	public CompanyServiceImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
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
				companyToUpdate.setJobs(company.getJobs());
				
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
	
}
