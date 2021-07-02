package com.liuwei.springan.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author wee
 * @Description:
 * @date 2020/6/24 15:07
 */
@Aspect
public class LogNotice {

    @Pointcut("execution(public int com.liuwei.springan.dao.Tomcat.sum(int,int))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("我在执行before");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("我在执行after");
    }

    @AfterReturning("pointCut()")
    public void afterReturn() {
        System.out.println("我在执行afterReturn");
    }

    @AfterThrowing("pointCut()")
    public void afterThrow() {
        System.out.println("执行时遇到错误");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("我在执行环绕之前");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("我在执行环绕之后");
        return proceed;
    }
}
