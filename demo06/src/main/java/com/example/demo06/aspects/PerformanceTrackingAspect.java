package com.example.demo06.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {
    
    private Logger logger = LoggerFactory.getLogger(getClass());

    // @Around("execution(* com.example.demo06.business.*.*.*(..))")
    // change for @Tracktime
    @Around("exectution(com.example.demo06.aspects.CommonPointcutConfig.tracktimeAnnotaion())")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        
        // start a timer
        long startTimeMillis = System.currentTimeMillis();

        Object returnValue = proceedingJoinPoint.proceed();

        // stop a timer
        long stopTimeMillis = System.currentTimeMillis();

        long executeDuration = stopTimeMillis - startTimeMillis;

        logger.info("Around Aspect - Method: {}, duration: {} ms", proceedingJoinPoint, executeDuration);
        return returnValue;
    }
}
