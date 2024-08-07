package com.example.demo06.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {
    
    @Pointcut("execution(* com.example.demo06.*.*.*(..))")
    public void businessAndDataPackageConfig() {}

    @Pointcut("execution(* com.example.demo06.business.*.*(..))")
    public void businessPackageConfig() {}

    @Pointcut("execution(* com.example.demo06.data.*.*(..))")
    public void dataPackageConfig() {}

    @Pointcut("bean(*Service*)")
    public void allPackageConfigUsingBean() {}

    @Pointcut("@annotation(com.example.demo06.annotations.Tracktime)")
    public void TracktimeAnnotation() {}
}
