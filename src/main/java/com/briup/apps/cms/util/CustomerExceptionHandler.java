package com.briup.apps.cms.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sun.awt.ConstrainableGraphics;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolationException;

/**
 * @Atuhor: qin
 * @Create: 2019-12-20-09-55
 * @Time: 9:55
 * @Description:
 */
@RestControllerAdvice
public class CustomerExceptionHandler {
    //将异常信息拦截
    @ExceptionHandler(value = Exception.class)
    public Message handler(Exception exception){
        //拦截到的异常信息封装为Message，然后交给Controller返回给前端
        //系统异常（不希望被看到）和业务异常分开写安全

        /**
         * 后台打印异常
         */
        //exception.printStackTrace();

        //系统异常：数组越界，空指针，数据库连接异常都统一为后台系统异常（代码编写语法错误导致的异常）
        String msg="系统异常";

        //业务异常：保存，登录，删除没有权限（用户使用所导致的异常）
        //此处--自定义异常||参数异常
        if(exception instanceof CustomerException ||exception instanceof ConstraintViolationException){
            msg=exception.getMessage();
        }
        return MessageUtil.error(msg);
    }
}
