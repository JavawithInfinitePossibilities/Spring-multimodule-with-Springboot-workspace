/**
 * 
 */
package com.tutorials.springboot.main;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @author Lenovo
 *
 */
public class MyJobListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("JOB is about to start");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("JOB is finished " + jobExecution.getStatus().toString());
	}

}
