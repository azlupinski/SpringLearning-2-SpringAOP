package pl.adamlupinski.springlearning.aopwithspringboot.service.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import pl.adamlupinski.springlearning.aopwithspringboot.model.Book;


import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

    @Before("pl.adamlupinski.springlearning.aopwithspringboot.service.aspects.AspectsUtil.allBookRepositoryMethods()")
    public void logInfoBefore(JoinPoint joinPoint){

        Object[] args = joinPoint.getArgs();
        System.out.printf("Log before %s method execution with arguments: %s\n",
        joinPoint.getSignature(),
                Arrays.toString(args));
    }

    @After("pl.adamlupinski.springlearning.aopwithspringboot.service.aspects.AspectsUtil.allBookRepositoryMethods()")
    public void logInfoAfter(){
        System.out.println("Log after method execution");
    }

//    @AfterThrowing("execution(* pl.adamLupinski.springLearning.AOP.service.BookRepository.*(..))")
    @AfterThrowing(pointcut = "pl.adamlupinski.springlearning.aopwithspringboot.service.aspects.AspectsUtil.allBookRepositoryMethods()", throwing = "error")
    public void logError(JoinPoint joinPoint, Throwable error){
        System.out.printf("Method %s finished with Error: %s\n",joinPoint.getSignature(), error.getMessage());
    }

    @AfterReturning(pointcut = "execution(* pl.adamlupinski.springlearning.aopwithspringboot.service.BookRepository.get(..)) && args(isbn)", returning = "result")
    public void logSuccess(JoinPoint joinPoint, String isbn, Book result){
        System.out.printf("Method get() has successfully returned value %s for isbn %s\n",result,isbn);
    }
}
