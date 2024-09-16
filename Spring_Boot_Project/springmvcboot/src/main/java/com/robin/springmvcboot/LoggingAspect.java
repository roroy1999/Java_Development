package com.robin.springmvcboot;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.robin.springmvcboot.model.Alien;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(public * com.robin.springmvcboot.SpringRestController.getAliens())")
	public void logBefore() {
		LOGGER.info("getAlien method called from aspect before");
	}
	
	@After("execution(public * com.robin.springmvcboot.SpringRestController.getAliens())")
	public void logAfter() {
		LOGGER.info("getAlien method called from Aspect After");
	}
	
	@AfterReturning("execution(public * com.robin.springmvcboot.SpringRestController.getAliens())")
	public void logAfterReturn() {
		LOGGER.info("getAlien method called from Aspect Afterreturn");
	}
	
	@AfterThrowing("execution(public * com.robin.springmvcboot.SpringRestController.getAliens())")
	public void logAfterException() {
		LOGGER.info("got error");
	}
}
