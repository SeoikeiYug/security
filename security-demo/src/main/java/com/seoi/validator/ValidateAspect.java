package com.seoi.validator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * @author shuaiqi
 * @create 2018-07-24 16:12
 * @desc 切片验证
 **/
@Aspect
@Component
public class ValidateAspect {

    @Around("execution(* com.seoi.web.controller.UserController.*(..))")
    public Object handleValidateResult(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("进入切片");

        final Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult errors = (BindingResult)arg;
                if (errors.hasErrors()) {
                    throw new ValidateException(errors.getAllErrors());
                }
            }
        }

        return proceedingJoinPoint.proceed();
    }

}
