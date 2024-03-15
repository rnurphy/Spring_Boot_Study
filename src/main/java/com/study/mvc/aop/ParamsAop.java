package com.study.mvc.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component  // IOC에 등록되어야함
public class ParamsAop {

    @Pointcut("@annotation(com.study.mvc.aop.annotation.ParamsAspect)")
    private void pointCut() {}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object[] args = proceedingJoinPoint.getArgs();

        CodeSignature codeSignature = (CodeSignature) proceedingJoinPoint.getSignature();   // 다운캐스팅
        String[] paramsName = codeSignature.getParameterNames();    // 매개변수명
        String className = codeSignature.getDeclaringTypeName();    // 클래스명
        String methodName = codeSignature.getName();                // 메소드명

        for(int i = 0; i < args.length; i++) {
            log.info("{}: {} >>> ({}.{}) ", paramsName[i], args[i], className, methodName);
        }

        log.info("전처리");

        Object result = proceedingJoinPoint.proceed();  // 비즈니스 로직(실제 실행되는 로직) / 컨트롤러 쪽

        log.info("후처리");
        log.info("response: {}", result);

        return result;
    }















}
