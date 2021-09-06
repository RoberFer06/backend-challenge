package com.skytel.challenge.login_backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ApiLogs {

    protected  final Logger logger = LoggerFactory.getLogger(ApiLogs.class);

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void allResources() {
        // don't need code
    }

    @Before("allResources()")
    public void apiRequestLog(JoinPoint jp) {
        logger.info("------------------------- o -------------------------");
        StringBuilder log = new StringBuilder(jp.getSignature().getName() + " >>>");
        for (Object arg : jp.getArgs()) {
            String stringArg = null;
            try {
                stringArg = new ObjectMapper().writeValueAsString(arg);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            if (stringArg != null){
                log.append("\n   ARG: ").append(stringArg);
            }else {
                log.append("\n   ARG: ").append(arg);
            }

        }
        logger.info(String.valueOf(log));
    }

    @AfterReturning(pointcut = "allResources()", returning = "result")
    public void apiResponseLog(JoinPoint jp, Object result) {
        ObjectMapper mapper = new ObjectMapper();
        String resultAsString;
        try {
            resultAsString = mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            resultAsString = result.toString();
        }
        String log = "<<< Return << " + jp.getSignature().getName() + ": " + resultAsString;
        if (log.length() > 1000) {
            log = log.substring(0, 1000) + ".... (+" + log.length() + " characters)";
        }
        logger.info(log);
    }

    @AfterThrowing(pointcut = "allResources()", throwing = "exception")
    public void apiResponseExceptionLog(JoinPoint jp, Exception exception) {
        String log = "<<< Return Exception << " + jp.getSignature().getName() + ": "
                + exception.getClass().getSimpleName() + "->" + exception.getMessage();
        logger.info(log);
    }
}
