package com.example.demo06.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // Pointcut - when ?
    // execution( * PACKAGE.*.*(..))
    // @Before("execution(* com.example.demo06.*.*.*(..))")
    @Before("exectution(com.example.demo06.aspects.CommonPointcutConfig.allPackageConfigUsingBean())")
    public void logBeforeMethodCall(JoinPoint joinPoint) {

        // logger.info("Before Aspect - Method is called: {}", joinPoint);
        logger.info("Before Aspect - Method is called: {}, with args: {}", joinPoint, joinPoint.getArgs());
    }

    // @After("execution(* com.example.demo06.*.*.*(..))")
    @After("exectution(com.example.demo06.aspects.CommonPointcutConfig.businessPackageConfig())")
    public void logAfterMethodCall(JoinPoint joinPoint) {

        logger.info("After Aspect - Method is called: {}, with args: {}", joinPoint, joinPoint.getArgs());
    }

    // @AfterReturning(
    //     pointcut = "execution(* com.example.demo06.*.*.*(..))", 
    //     returning = "resultValue"
    // )
    @AfterReturning(
        pointcut = "exectution(com.example.demo06.aspects.CommonPointcutConfig.dataPackageConfig())",
        returning = "resultValue"
    )
    public void logAfterMethodCallSuccess(JoinPoint joinPoint, Object resultValue) {

        logger.info("After Aspect - Method is called: {}, with args: {}, returns: {}", joinPoint, joinPoint.getArgs(), resultValue);
    }

    // @AfterThrowing(
    //     pointcut = "execution(* com.example.demo06.*.*.*(..))",
    //     throwing = "exception"
    // )
    @AfterThrowing(
        pointcut = "exectution(com.example.demo06.aspects.CommonPointcutConfig.businessAndDataPackageConfig())",
        throwing = "exception"
    )
    public void logAfterMethodCallError(JoinPoint joinPoint, Exception exception) {

        logger.info("After Aspect - Method is called: {}, with args: {}, throws: {}", joinPoint, joinPoint.getArgs(), exception);
    }

}