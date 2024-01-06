package com.kavish.tutorials.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;

@Aspect
public class LogResponseTimeAspect {

    @Around(value = "@annotation(logResponseTimeAnnotation)")
    public Object restLog(ProceedingJoinPoint joinPoint, LogResponseTime logResponseTimeAnnotation) throws Throwable {
        Logger log = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        String apiName = logResponseTimeAnnotation.apiName();
        Instant startTime = Instant.now();
        Object object = joinPoint.proceed();
        Instant endTime = Instant.now();
        log.info("Total Time Taken for Processing {} in Milliseconds {}", apiName, Duration.between(startTime, endTime).toMillis());
        return object;
    }
}
