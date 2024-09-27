package com.robin.jobms.job.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.robin.jobms.job.Job;
import com.robin.jobms.job.JobRepository;
import com.robin.jobms.job.JobService;
import com.robin.jobms.job.clients.CompanyClient;
import com.robin.jobms.job.clients.ReviewClient;
import com.robin.jobms.job.dto.JobDTO;
import com.robin.jobms.job.external.Company;
import com.robin.jobms.job.external.Review;
import com.robin.jobms.job.mapper.JobMapper;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class JobServiceImpl implements JobService{
	
	//private List<Job> jobs = new ArrayList<>();
	JobRepository jobRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	CompanyClient companyClient;
	
	int attempt = 0;
	
	ReviewClient reviewClient;

	public JobServiceImpl(JobRepository jobRepository,CompanyClient companyClient,ReviewClient reviewClient) {
		super();
		this.jobRepository = jobRepository;
		this.companyClient = companyClient;
		this.reviewClient = reviewClient;
	}

	@Override
//	@CircuitBreaker(name="companyBreaker",fallbackMethod = "companyBreakerFallback")
//	@Retry(name="companyBreaker",fallbackMethod = "companyBreakerFallback")
	@RateLimiter(name="companyBreaker",fallbackMethod = "companyBreakerFallback")
	public List<JobDTO> findAll() {
		// TODO Auto-generated method stub
		System.out.println("Attempt   :" + ++attempt);
		List<Job> jobs = jobRepository.findAll();
		//List<JobWithCompanyDTO> jobWithCompanyDTOs = new ArrayList<>();
		return jobs.stream().map((job)->convertToDto(job)).collect(Collectors.toList());
	}
	
	public List<String> companyBreakerFallback(Exception e){
		List<String> list = new ArrayList<>();
		list.add("Dummy");
		return list;
	}
	
	private JobDTO convertToDto(Job job) {
//		RestTemplate Way:- 
		
//		Company company = restTemplate.getForObject("http://COMPANY-SERVICE/companies/{companyId}",Company.class,job.getCompanyId());
//		ResponseEntity<List<Review>> reviewResponse  = restTemplate.exchange("http://REVIEW-SERVICE/reviews?CompanyId="+
//		job.getCompanyId(),HttpMethod.GET,null,new ParameterizedTypeReference<List<Review>>() {
//		});
//		List<Review> reviews = reviewResponse.getBody();
		
		Company company = companyClient.getCompany(job.getCompanyId());
		
		List<Review> reviews = reviewClient.getReviews(job.getCompanyId());
		
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
