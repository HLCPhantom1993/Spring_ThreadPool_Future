package com.honglin_chen.spring_threadpool_callable.controller;

import java.util.ArrayList; 
import java.util.List; 
import java.util.concurrent.Future; 

import org.springframework.web.bind.annotation.RestController; 
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired; 

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor; 

import com.honglin_chen.spring_threadpool_callable.callabletask.CallableWorker;

@RestController
public class WebController {
	@Autowired
	ThreadPoolTaskExecutor threadPool; 
	
	@RequestMapping("/process")
	public String process() {
		String msg = ""; 
		List<Future<String>> futureList = new ArrayList<>();
		for(int i = 0; i < 5; ++i) {
			CallableWorker worker = new CallableWorker(String.valueOf(i));
			Future<String> res = threadPool.submit(worker);
			futureList.add(res); 
		}
		
		for(Future<String> future: futureList) {
			try {
				msg += future.get(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return msg; 
	}
}
