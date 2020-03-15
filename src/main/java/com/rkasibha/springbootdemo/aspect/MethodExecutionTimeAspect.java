package com.rkasibha.springbootdemo.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodExecutionTimeAspect {

    private static final Logger logger = LoggerFactory.getLogger(MethodExecutionTimeAspect.class);

    @Around("@annotation(com.rkasibha.springbootdemo.annotation.MeasureExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        logger.info("Time taken by " + pjp + ": " + (end-start) + " milliseconds");
        return result;
    }

    @Around("execution(* com.rkasibha.springbootdemo.repository.*.*(..))")
    public Object measureRepositoryExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        logger.info("{} took {} ms", pjp, (end-start));
        return result;
    }
}
