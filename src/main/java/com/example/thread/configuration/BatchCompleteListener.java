package com.example.thread.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class BatchCompleteListener implements JobExecutionListener {
	
	private static final Logger log = LoggerFactory.getLogger(BatchCompleteListener.class);

		@Override
		public void afterJob(JobExecution jobExecution) {
			
			log.info("After Job:"+jobExecution.getStatus());
		}

		@Override
		public void beforeJob(JobExecution jobExecution) {
			
		log.info("Before Job:"+jobExecution.getStatus());
		}
		
	
	

}
