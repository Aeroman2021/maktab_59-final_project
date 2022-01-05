package com.example.finalproject.AOP;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class Logger {
    



//    @Pointcut("execution( * com.example.finalproject.service.*.*(..))")
//    public void loggingPointCut() {}
//
//    @Before("loggingPointCut()")
//    public void before(JoinPoint joinPoint) {
//        log.info("Before method invoked::" + joinPoint.getSignature());
//    }
//
//    @After("loggingPointCut()")
//    public void after(JoinPoint joinPoint) {
//        log.debug("After method invoked::" + joinPoint.getSignature());
//    }

//    @Before("execution(* com.example.finalproject.*.*(..))")
//    public void infoLog(JoinPoint joinPoint){
//        log.info("Before method invoked:: " + joinPoint.getSignature())
//
//    }
//
//    @After("execution(* com.example.finalproject.*.*(..))")
//    public void debugLog(JoinPoint joinPoint){
//        log.debug("After method invoked:: " + joinPoint.getSignature());
//    }

    @Around("execution(* com.example.finalproject.*.*(..))")
    public Object logAndDebug(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Before method invoked:: " + joinPoint.getSignature());
        joinPoint.proceed();
        log.debug("After method invoked:: " + joinPoint.getSignature());

        return joinPoint.getSignature();
    }


}
