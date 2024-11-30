package com.programmingpointer.JobPortal.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);


    @Around("execution(* com.programmingpointer.JobPortal.service.JobService.getJobPostByID(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint jp , int postId) throws Throwable {

        if(postId < 0){
            LOGGER.info("PostId is negative, update it.");
            postId = - postId;
            LOGGER.info("new value : "+ postId);
        }

        Object obj = jp.proceed(new Object[]{postId});

        return obj;

    }
}
