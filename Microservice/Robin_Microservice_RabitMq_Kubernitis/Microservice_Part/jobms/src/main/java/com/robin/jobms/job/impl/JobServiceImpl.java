package com.robin.jobms.job.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.robin.jobms.job.Job;
import com.robin.jobms.job.JobRepository;
import com.robin.jobms.job.JobService;
import com.robin.jobms.job.dto.JobWithCompanyDTO;
import com.robin.jobms.job.external.Company;

@Service
public class JobServiceImpl implements JobService{
	
	//private List<Job> jobs = new ArrayList<>();
	JobRepository jobRepository;

	public JobServiceImpl(JobRepository jobRepository) {
		super();
		this.jobRepository = jobRepository;
	}

	@Override
	public List<JobWithCompanyDTO> findAll() {
		// TODO Auto-generated method stub
		List<Job> jobs = jobRepository.findAll();
		List<JobWithCompanyDTO> jobWithCompanyDTOs = new ArrayList<>();
		
		
		return jobs.stream().map((job)->convertToDto(job)).collect(Collectors.toList());
	}
	
	private JobWithCompanyDTO convertToDto(Job job) {
		RestTemplate restTemplate = new RestTemplate();
		JobWithCompanyDTO jobWithCompanyDTO = new JobWithCompanyDTO();
		jobWithCompanyDTO.setJob(job);
		Company company = restTemplate.getForObject("http://localhost:8083/companies/{companyId}",Company.class,job.getCompanyId());
		jobWithCompanyDTO.setCompany(company);
		return jobWithCompanyDTO;
	}

	@Override
	public void createJob(Job job) {
		// TODO Auto-generated method stub
		jobRepository.save(job);
	}

	@Override
	public Job getJobById(Long id) {
		// TODO Auto-generated method stub
		
		return jobRepository.findById(id).orElse(new Job());
	}

	@Override
	public boolean deleteJobById(Long id) {
		// TODO Auto-generated method stub
		try {
			
			jobRepository.deleteById(id);
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateJob(Long id, Job updatedJob) {
		Optional<Job> jobOption = jobRepository.findById(id);
		// TODO Auto-generated method stub
		
			if(jobOption.isPresent()) {
				
				Job job = jobOption.get();
				job.setTitle(updatedJob.getTitle());
				job.setDescription(updatedJob.getDescription());
				job.setLocation(updatedJob.getLocation());
				job.setMaxSalary(updatedJob.getMaxSalary());
				job.setMinSalary(updatedJob.getMinSalary());
				
				jobRepository.save(job);
				return true;
			}
		return false;
	}

}
