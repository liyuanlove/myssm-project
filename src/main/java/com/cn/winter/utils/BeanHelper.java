package com.cn.winter.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cn.winter.pojo.User;

/**
 * 权限拦截AOP
 * @author Administrator
 *
 */
@Component
@Aspect
public class BeanHelper {

	private final Logger log = LoggerFactory.getLogger(BeanHelper.class);
	
	@Pointcut("within(com.cn.winter.controller..*) && !within(com.cn.winter.controller.login.LoginController)")
	public void pointCut(){}
	
	@Around("pointCut()")
	public Object trackInfo(ProceedingJoinPoint pjp) throws Throwable {
		User user = (User) SysContent.getSession().getAttribute("userInfo");
		String userRole = (String) SysContent.getSession().getAttribute("userRole");
		if(user == null || userRole == null) {
			log.info("-------------没有登录-------------");
			return "redirect:/login";
		}
		return pjp.proceed();
	}
	
	
}
