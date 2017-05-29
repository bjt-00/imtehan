package com.bitguiders.imtehan.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//Step-I : dispatcher-servlet.xml -> <aop:aspectj-autoproxy/>
//Step-II: write following code

@Aspect
@Component
public class ExampAOP {

	@After("execution(* com.bitguiders.imtehan.service.rest..*.*(..))")
	public void afterMthodCall(JoinPoint joinPoint){
		System.out.println("***************aop-> After****************");
		System.out.println("Method hijacked : "+joinPoint.getSignature().getName());
	}
	
	@AfterReturning(pointcut="execution(* com.bitguiders.imtehan.service.rest..*.*(..))",
			        returning="result")
	public void afterReturningMthodCall(JoinPoint joinPoint,Object result){
		System.out.println("***************aop-> After Returning ****************");
		System.out.println("Method hijacked : "+joinPoint.getSignature().getName());
		System.out.println("Method return value is : "+result);
	}
	@AfterThrowing(pointcut="execution(* com.bitguiders.imtehan.service.rest..*.*(..))",
	        throwing="error")
		public void afterThrowingExceptionMthodCall(JoinPoint joinPoint,Throwable error){
		System.out.println("***************aop-> After Returning ****************");
		System.out.println("Method hijacked : "+joinPoint.getSignature().getName());
		System.out.println("Method return value is : "+error);
		}

}
