package hello.hellospring.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

  @Around("execution(* hello.hellospring..*(..))")
  public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
    Object result = joinPoint.proceed();
    long start = System.currentTimeMillis();
    System.out.println("START" + joinPoint.toString());
    try {
      return joinPoint.proceed();
    } finally {
      long finish = System.currentTimeMillis();
      long timeMs = start - finish;
      System.out.println("END" + joinPoint.toString() + " " + timeMs + "ms");
    }
  }
}
