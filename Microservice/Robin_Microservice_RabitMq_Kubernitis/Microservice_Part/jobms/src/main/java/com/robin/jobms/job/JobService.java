package com.robin.jobms.job;

import java.util.List;

import com.robin.jobms.job.dto.JobDTO;

public interface JobService {
	
	List<JobDTO> findAll();
	
	void createJob(Job bob);

	JobDTO getJobById(Long id);

	boolean deleteJobById(Long id);

	boolean updateJob(Long id, Job updatedJob);

}
