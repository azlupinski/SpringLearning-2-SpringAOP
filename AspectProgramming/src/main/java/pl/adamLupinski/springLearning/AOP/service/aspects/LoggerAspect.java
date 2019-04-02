package pl.adamLupinski.springLearning.AOP.service.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    @Before("execution(* pl.adamLupinski.springLearning.AOP.service.BookRepository.*(..))")
    public void logInfoBefore(){
        System.out.println("Log before method execution");
    }

    @After("execution(* pl.adamLupinski.springLearning.AOP.service.BookRepository.*(..))")
    public void logInfoAfter(){
        System.out.println("Log after method execution");
    }

    @AfterThrowing("execution(* pl.adamLupinski.springLearning.AOP.service.BookRepository.*(..))")
    public void logError(){
        System.out.println("Log after method finished with Error");
    }

    @AfterReturning("execution(* pl.adamLupinski.springLearning.AOP.service.BookRepository.*(..))")
    public void logSuccess(){
        System.out.println("Log after method finished with success");
    }
}
