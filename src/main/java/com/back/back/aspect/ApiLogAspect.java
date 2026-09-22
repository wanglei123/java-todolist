package com.back.back.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class ApiLogAspect {

    @Around("execution(* com.back.back.controller..*(..))")
    public Object logApi(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().toShortString();
        log.info("接口入参 {} args={}", method, Arrays.toString(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        log.info("接口出参 {} result={}", method, result);
        return result;
    }
}
