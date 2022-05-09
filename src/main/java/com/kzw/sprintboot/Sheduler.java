package com.kzw.sprintboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kzw.sprintboot.service.StudentService;

@Component
@EnableScheduling
public class Sheduler {
	
	@Autowired
	StudentService studentService;
	
	final static Logger logger = LoggerFactory.getLogger(Sheduler.class);
	
	@Scheduled(cron= "0 * * ? * *")
	public void log() {
		logger.info("Total Students = " + studentService.getTotalCount().toString());
	}
	
}
