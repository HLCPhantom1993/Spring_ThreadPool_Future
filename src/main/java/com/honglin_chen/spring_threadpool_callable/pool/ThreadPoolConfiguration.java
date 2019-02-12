package com.honglin_chen.spring_threadpool_callable.pool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; 

import org.springframework.beans.factory.annotation.Value;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor; 

/* 构造线程池 */ 
@Configuration
public class ThreadPoolConfiguration {
	@Value("${threadpool.corepoolsize}")
	int corePoolSize; 
	
	@Value("${threadpool.maxpoolsize}")
	int maxPoolSize; 
	
	@Bean
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor(); 
		pool.setCorePoolSize(corePoolSize);
		pool.setMaxPoolSize(maxPoolSize);
		
		pool.setWaitForTasksToCompleteOnShutdown(true);
		
		return pool; 
	}
}
