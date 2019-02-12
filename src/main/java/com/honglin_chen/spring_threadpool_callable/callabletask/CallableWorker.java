package com.honglin_chen.spring_threadpool_callable.callabletask;

import java.util.concurrent.Callable; 

public class CallableWorker implements Callable<String> {
	String name; 
	
	public CallableWorker(String name) {
		this.name = name; 
	}
	
	@Override 
	public String call() throws Exception {
		process(); 
		String message = String.format("Callable Worker: %s 完成了任务: ", name); 
		return message; 
	}
	
	private void process() {
		for(int i = 0; i < 10; ++i) {
			String message = String.format("Callable Worker: %s 正在处理任务: %d", name, i); 
			System.out.println(message); 
		}
	}
}
