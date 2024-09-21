package com.robin.firstjobapp.job.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.robin.firstjobapp.job.Job;
import com.robin.firstjobapp.job.JobRepository;
import com.robin.firstjobapp.job.JobService;

@Service
public class JobServiceImpl implements JobService{
	
	//private List<Job> jobs = new ArrayList<>();
	JobRepository jobRepository;

	public JobServiceImpl(JobRepository jobRepository) {
		super();
		this.jobRepository = jobRepository;
	}

	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return jobRepository.findAll();
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
