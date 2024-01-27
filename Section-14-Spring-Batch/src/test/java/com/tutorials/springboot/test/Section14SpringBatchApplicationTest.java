/**
 * 
 */
package com.tutorials.springboot.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tutorials.springboot.main.Section14SpringBatchApplication;

/**
 * @author Lenovo
 *
 */
@SpringBootTest(classes = Section14SpringBatchApplication.class)
public class Section14SpringBatchApplicationTest {

	@Disabled
	@Test
	void contextLoads() {
		System.out.println("Welcome to spring boot tutorials...");
	}

	@Autowired
	private JobLauncher jobLuncher;

	@Autowired
	private Job job;

	// @Disabled
	@Test
	void testBatch() throws JobExecutionAlreadyRunningException, JobRestartException,
			JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		JobParameters jobParameters = new JobParametersBuilder().toJobParameters();
		jobLuncher.run(job, jobParameters);
	}
}
