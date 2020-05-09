package com.customer.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppLogging {

  private static final Logger LOG = LoggerFactory.getLogger(AppLogging.class);

  @Around("execution(* com.mobile..*(..)))")
  public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

    String className = methodSignature.getDeclaringType().getSimpleName();
    String methodName = methodSignature.getName();

    LOG.info("Entered into {} method of {} class", methodName, className);

    Object result = proceedingJoinPoint.proceed();

    LOG.info("Exited from {} method of {} class", methodName, className);

    return result;
  }

  @AfterThrowing(pointcut = "execution(* com.mobile..*(..)))", throwing = "e")
  public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {

    Signature signature = joinPoint.getSignature();
    String className = signature.getDeclaringType().getSimpleName();
    String methodName = signature.getName();

    LOG.error("{} exception accured in {} of {}", e.getClass().getName(), methodName, className, e);
  }
}
