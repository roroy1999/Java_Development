package com.robin.jobms.job;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.robin.jobms.job.dto.JobWithCompanyDTO;
import com.robin.jobms.job.external.*;

@RestController
@RequestMapping("/jobs")
public class JobController {
	
	private JobService jobService;
	
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}
	
	@GetMapping
	public ResponseEntity<List<JobWithCompanyDTO>> findAll(){
		//System.out.println("COMPANY : "+ company);
		return ResponseEntity.ok(jobService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<String> createJob(@RequestBody Job job) {
		jobService.createJob(job);
		return new ResponseEntity<>("Job added successfully",HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<JobWithCompanyDTO> getJobById(@PathVariable Long id) {
		JobWithCompanyDTO jobWithCompanyDTO = jobService.getJobById(id);
		if (jobWithCompanyDTO!=null) {
			return new ResponseEntity<>(jobWithCompanyDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJob(@PathVariable Long id){
		boolean deleted = jobService.deleteJobById(id);
		
		if(deleted)
			return new ResponseEntity<String>("Job deleted successfully",HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> UpdatedJob(@PathVariable Long id,@RequestBody Job updatedJob){
		boolean updated = jobService.updateJob(id,updatedJob);
		
		if(updated)
			return new ResponseEntity<String>("Job updated successfully",HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


}
