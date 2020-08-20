package org.j2os.monitor.modules.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Rater {
    @Around("execution(* org.j2os.monitor.modules.*.controller.*.*(..)) ")
    public void perform(ProceedingJoinPoint point) throws Throwable {
//        System.out.println("before point cut");
        point.proceed();
//        System.out.println("after point cut");

    }

}
