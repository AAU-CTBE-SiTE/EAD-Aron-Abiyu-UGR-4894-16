package site.example.lab6.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    private static final Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);

    // Intercept all service methods
    @Around("execution(* com.site.lab6.service.*.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // Execute the actual method
        Object result = joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;

        logger.info("⏱️ [Performance] Method '{}' took {} ms to execute.",
                joinPoint.getSignature().getName(), timeTaken);

        return result;
    }
}