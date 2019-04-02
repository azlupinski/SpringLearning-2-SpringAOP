package pl.adamlupinski.springlearning.aopwithspringboot.service.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
public class TimeLoggerAspect {

    @Around("pl.adamlupinski.springlearning.aopwithspringboot.service.aspects.AspectsUtil.allBookRepositoryMethods()")
    public Object measureTime(ProceedingJoinPoint pjp) throws Throwable{
        Instant before = Instant.now();
        //@Before
        try{
            Object result = pjp.proceed();
            //@after
            return result;
        } finally {
            //AfterReturning
            Instant after = Instant.now();
            Duration methodExecutionTime = Duration.between(before, after);
            System.out.printf("%s Method execution time: %d ms\n",pjp.toShortString(),methodExecutionTime.toMillis());

        }
    }

}
