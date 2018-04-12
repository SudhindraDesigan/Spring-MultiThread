package com.example.thread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

@SpringBootApplication
public class SampleMultiThreadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleMultiThreadApplication.class, args);
	}
	
	
}
