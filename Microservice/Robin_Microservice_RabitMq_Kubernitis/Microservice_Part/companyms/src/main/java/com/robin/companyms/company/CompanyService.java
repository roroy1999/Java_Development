package com.robin.companyms.company;

import java.util.List;

import com.robin.companyms.company.dto.ReviewMessage;

public interface CompanyService {
	
	List<Company> getAllCompanies();
	
	boolean updatedCompany(Company company,Long id);
	
	void createCompany(Company company);
	
	boolean deleteCompanyById(Long id);
	
	Company getCompanyById(Long id);

	public void updatedCompany(ReviewMessage reviewMessage);
	
}
