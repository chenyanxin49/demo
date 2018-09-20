package com.example.common;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Description 异常处理切面
 * @author yukun
 * @date 2018/8/29 14:12
 * @version 1.0
 * Order 数字越低执行的顺序越前
 **/
@Component
@Aspect
@Order(0)
public class AspectForException {

    private static final String AOP_POINTCUT_EXPRESSION = "execution(* com.example.service..*(..))";

    /**
     * 后置异常通知
     *  定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
     *  throwing 限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
     *      对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。
     */
    @AfterThrowing(value = AOP_POINTCUT_EXPRESSION,throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception){
        System.out.println("service aspect");
        System.out.println(joinPoint.getSignature().getName());
        System.out.println(joinPoint.getSignature().getName() + exception);
    }
}
