package site.example.lab6.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAspect {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

    @AfterThrowing(pointcut = "execution(* com.site.lab6.service.*.*(..))", throwing = "exception")
    public void handleException(JoinPoint joinPoint, Throwable exception) {
        // You can log it, send an email, or trigger an alert system here
        logger.error("🚨 [ExceptionAspect] Intercepted error in '{}'. Message: '{}'",
                joinPoint.getSignature().getName(),
                exception.getMessage());

        // Note: Because this is @AfterThrowing, it does NOT swallow the exception.
        // It will still bubble up and cause a 500 error in Postman.
    }
}
