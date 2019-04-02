package pl.adamlupinski.springlearning.aopwithspringboot.service.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectsUtil {
    @Pointcut("execution(* pl.adamlupinski.springlearning.aopwithspringboot.service.BookRepository.*(..))")
    public void allBookRepositoryMethods(){}
}
