package com.robin.jobms.job.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.robin.jobms.job.Job;
import com.robin.jobms.job.JobRepository;
import com.robin.jobms.job.JobService;
import com.robin.jobms.job.dto.JobDTO;
import com.robin.jobms.job.external.Company;
import com.robin.jobms.job.external.Review;
import com.robin.jobms.job.mapper.JobMapper;

@Service
public class JobServiceImpl implements JobService{
	
	//private List<Job> jobs = new ArrayList<>();
	JobRepository jobRepository;
	
	@Autowired
	RestTemplate restTemplate;

	public JobServiceImpl(JobRepository jobRepository) {
		super();
		this.jobRepository = jobRepository;
	}

	@Override
	public List<JobDTO> findAll() {
		// TODO Auto-generated method stub
		List<Job> jobs = jobRepository.findAll();
		//List<JobWithCompanyDTO> jobWithCompanyDTOs = new ArrayList<>();
		
		
		return jobs.stream().map((job)->convertToDto(job)).collect(Collectors.toList());
	}
	
	private JobDTO convertToDto(Job job) {
		//RestTemplate restTemplate = new RestTemplate();
		Company company = restTemplate.getForObject("http://COMPANY-SERVICE/companies/{companyId}",Company.class,job.getCompanyId());
		
		ResponseEntity<List<Review>> reviewResponse  = restTemplate.exchange("http://REVIEW-SERVICE/reviews?CompanyId="+
		job.getCompanyId(),HttpMethod.GET,null,new ParameterizedTypeReference<List<Review>>() {
		});
		
		List<Review> reviews = reviewResponse.getBody();
		
		JobDTO jobWithCompanyDTO = JobMapper.mapToJobWithCompanyDTO(job, company, reviews);
		return jobWithCompanyDTO;
	}

	@Override
	public void createJob(Job job) {
		// TODO Auto-generated method stub
		jobRepository.save(job);
	}

	@Override
	public JobDTO getJobById(Long id) {
		// TODO Auto-generated method stub
		Job job =jobRepository.findById(id).orElse(new Job());
		return convertToDto(job);
		
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
