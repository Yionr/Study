package cn.yionr.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LogUtils {
//    @Before("execution(void cn.yionr.dao.impl.UserDaoImpl.getUser())")
    public void start(JoinPoint joinPoint){
        System.out.println("start");
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        System.out.println(joinPoint.getSignature());
    }
//    @After("execution(void cn.yionr.dao.impl.UserDaoImpl.getUser())")
    public void end(){
        System.out.println("end");
    }

    public void fin(){
        System.out.println("finally");
    }

//    @AfterReturning(value="execution(* *..*.*(..))",returning = "i")
    public void ret(int i){
        System.out.println("return value is : " + i);
    }

//    @Around("execution(* *..*.*(..))")
    public Object surrund(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        try {
            System.out.println("before");
            result = pjp.proceed(pjp.getArgs());
            System.out.println("after returning");
        } catch (Throwable throwable) {
            System.out.println("after throwing");
        }
        finally {
            System.out.println("after");
            return result;
        }
    }
}
