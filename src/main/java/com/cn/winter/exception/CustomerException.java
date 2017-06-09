package com.cn.winter.exception;

/**
 * 客户异常信息
 * Created by Administrator on 2017/6/9.
 */
public class CustomerException extends RuntimeException{

    public CustomerException(String message) {
        super(message);
    }

    public CustomerException(String message, Throwable cause) {
        super(message, cause);
    }
}
