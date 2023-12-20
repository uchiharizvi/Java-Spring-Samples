package com.kavish.tutorials.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Component
@Aspect//What is this?
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(Loggable)")//What is this?
    public void executeLogging() {
    }

    /***Before***/
    /*@Before("executeLogging()")//Specify this annotation to execute before a method
    public void logMethodCall(JoinPoint joinPoint) {
        StringBuilder message = new StringBuilder("Method: ");
        message.append(joinPoint.getSignature().getName());//get a var value from join point(business logic) code
        Object[] args = joinPoint.getArgs();//get arguments of join point(business Logic)
        if (null != args && args.length > 0) {
            message.append(" args=[ | ");
            Arrays.asList(args).forEach(arg -> {//lambda expressions| Arrays.asList(to convert array to list)
                message.append(arg).append(" | ");
            });
            message.append("]");
        }
        LOGGER.info(message.toString());
    }*/

    /***After returning***/
    @AfterReturning(value = "executeLogging()", returning = "returnValue")
    //Specify this annotation to execute After a method is executed
    public void logMethodCall(JoinPoint joinPoint, Object returnValue) {
        StringBuilder message = new StringBuilder("Method: ");
        message.append(joinPoint.getSignature().getName());//get a var value from join point(business logic) code
        Object[] args = joinPoint.getArgs();//get arguments of join point(business Logic)
        if (null != args && args.length > 0) {
            message.append(" args=[ | ");
            Arrays.asList(args).forEach(arg -> {//lambda expressions| Arrays.asList(to convert array to list)
                message.append(arg).append(" | ");
            });
            message.append("]");
        }
        if (returnValue instanceof Collection) {
            message.append(", returning: ").append(((Collection) returnValue).size()).append(" instance(s)");
        } else {
            message.append(", returning: ").append(returnValue.toString());
        }
        LOGGER.info(message.toString());
    }
}
