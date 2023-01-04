package com.example.restdemo.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass {

    private static final Logger log = LoggerFactory.getLogger(AspectClass.class);

    @Pointcut("execution(public java.util.List<com.example.restdemo.Book> com.example.restdemo.BookService.getBooks())")
    public void getAllBooksMethodPointcut(){}

    @Around("getAllBooksMethodPointcut()")
    public void aroundGetAllBooksMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Incoming request: Get all books");
        joinPoint.proceed();
        log.info("request proceed");
    }

    @Pointcut("execution(public com.example.restdemo.Book com.example.restdemo.BookService.getBookById(..))")
    public void getBookByIdMethodPointcut(){}

    @Around("getBookByIdMethodPointcut()")
    public void aroundGetBookByIdMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Incoming request: Get book by ID");
        joinPoint.proceed();
        log.info("request proceed");
    }
}
