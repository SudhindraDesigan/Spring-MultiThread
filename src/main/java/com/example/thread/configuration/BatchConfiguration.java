package com.example.thread.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.example.thread.model.Product;


@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public ProductFileReader reader() {
		return new ProductFileReader();
	}
	
	@Bean
	public ProductProcessor processor() {
		return new ProductProcessor();
	}
	
	@Bean
	public ProductWriter writer() {
		return new ProductWriter();
	}
	@Bean
	
	public JobExecutionListener listener() {
		return new BatchCompleteListener();
	}
	
	@Bean
	public Job productJob() {
		return jobBuilderFactory.get("Product Job").incrementer(new RunIdIncrementer()).listener(listener()).flow(step()).end().build();
	}
	
	@Bean
	public Step step() {
		return stepBuilderFactory
				.get("Product Job Step")
				.<Product,Product>chunk(20)
				.reader(reader())
				.processor(processor()).writer(writer()).taskExecutor(asyncTaskExecutor()).build();
	}
	
	@Bean
	public TaskExecutor asyncTaskExecutor() {
		SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
		taskExecutor.setConcurrencyLimit(5);
	
		return taskExecutor;
	}
	/*@Bean
	public TaskExecutor syncTaskExecutor() {
		SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
		taskExecutor.setConcurrencyLimit(5);
		return taskExecutor;
	}*/

}
