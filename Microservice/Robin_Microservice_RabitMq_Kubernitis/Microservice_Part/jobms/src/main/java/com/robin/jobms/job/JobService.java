package com.robin.jobms.job;

import java.util.List;

import com.robin.jobms.job.dto.JobWithCompanyDTO;

public interface JobService {
	
	List<JobWithCompanyDTO> findAll();
	
	void createJob(Job bob);

	JobWithCompanyDTO getJobById(Long id);

	boolean deleteJobById(Long id);

	boolean updateJob(Long id, Job updatedJob);

}
