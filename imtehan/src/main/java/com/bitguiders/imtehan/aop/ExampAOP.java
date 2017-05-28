package com.bitguiders.imtehan.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampAOP {

	@After("execution(* com.bitguiders.imtehan.service.rest..*.*(..))")
	public void before(){
		System.out.println("***************aop****************");
	}
}
