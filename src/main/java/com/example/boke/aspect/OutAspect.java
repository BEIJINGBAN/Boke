package com.example.boke.aspect;

import com.example.boke.annotation.OUT;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author bjingban
 * @date 2025-07-18 02:08
 */
@Aspect
@Component
public class OutAspect {

    @Around(value = "@annotation(OUT)",argNames = "joinPoint,out")
    public Object handle(ProceedingJoinPoint joinPoint,OUT out) throws Throwable {
        String message = out.message();
        boolean before = out.logBefore();
        boolean after = out.logAfter();

        if (before) {
            System.out.println("[OUT - Before] " + message);
        }

        Object result = null;
        try {
            result = joinPoint.proceed(); // 执行目标方法
        } catch (Exception e) {
            System.err.println("[OUT - Exception] " + e.getMessage());
            throw e;
        }

        if (after) {
            System.out.println("[OUT - After] " + message);
        }

        return result;
    }
}
