package com.alaf.openapi.customer.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

	
	
	@Before("execution(* com.alaf.openapi.customer.*.*.*(..))")
	public void logBeforeServiceLayerAdvice(JoinPoint joinPoint) {
		log.info("Entering class {} method {}", new Object[] {joinPoint.getTarget().getClass().getName(), joinPoint.toString()}); 
		log.info("Arguments Passed= {}",  Arrays.toString(joinPoint.getArgs()));
				
	}
	
	@After("execution(* com.alaf.openapi.customer.*.*.*(..))")
	public void logAfterServiceLayerAdvice(JoinPoint joinPoint) {
		log.info("Exiting class {} method {}", new Object[] {joinPoint.getTarget().getClass().getName(),
				joinPoint.toString()}); 
				
	}
	
	
	/*
	@Pointcut(value ="execution(* com.alaf.openapi.customer.controller.*.*(..))")
	public void loggingPointcut() {}
	
	@Around ("loggingPointcut()")
	*/
	/*
	@Around("execution(* com.alaf.openapi.customer.*.*.*(..))")
	public Object logAroundAdvice(ProceedingJoinPoint jp) throws Throwable {
		
		ObjectMapper mapper = new ObjectMapper();
		String className = jp.getTarget().getClass().getName();
		String methodName = jp.getSignature().getName();
		
		Object[] args = jp.getArgs();
		log.info("Inside {} class method {}, with request: {}", 
				new Object[] {className, methodName, mapper.writeValueAsString(args) });
		Object response = jp.proceed();
		log.info("Inside {} class method {}, with response: {}", 
				new Object[] {className, methodName, mapper.writeValueAsString(response) });
		
		return response;
	}
	*/
	@AfterThrowing (pointcut = "execution(* com.alaf.openapi.customer.controller.*.*(..))", throwing = "ex")
    public void logAfterThrowingAllMethods(Exception ex) throws Throwable {
		log.info("****LoggingAspect.logAfterThrowingAllMethods(), message: {}", ex.getMessage());
    }
	
}
