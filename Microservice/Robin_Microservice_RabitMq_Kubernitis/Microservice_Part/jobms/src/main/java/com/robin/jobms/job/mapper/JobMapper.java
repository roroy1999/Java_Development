package com.robin.jobms.job.mapper;

import java.util.List;

import com.robin.jobms.job.Job;
import com.robin.jobms.job.dto.JobDTO;
import com.robin.jobms.job.external.Company;
import com.robin.jobms.job.external.Review;

public class JobMapper {
	public static JobDTO mapToJobWithCompanyDTO(Job job, Company company ,List<Review> review) {
		JobDTO jobWithCompanyDTO = new JobDTO();
		jobWithCompanyDTO.setId(job.getId());
		jobWithCompanyDTO.setTitle(job.getTitle());
		jobWithCompanyDTO.setDescription(job.getDescription());
		jobWithCompanyDTO.setLocation(job.getLocation());
		jobWithCompanyDTO.setMaxSalary(job.getMaxSalary());
		jobWithCompanyDTO.setMinSalary(job.getMinSalary());
		jobWithCompanyDTO.setCompany(company);
		jobWithCompanyDTO.setReviews(review);
		
		return jobWithCompanyDTO;
	}
}
