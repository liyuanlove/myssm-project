package com.cn.winter.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Winterchen
 *
 */
public class BaseController {
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	
	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}
	
	/**
	 * 将json文本转换成json数组
	 * @param text	文本
	 * @return	数组
	 */
	public static Object parse(String text){
		if(text == null && "".equals(text))
			return null;
		return JSON.parse(text);
	}
	
	/**
	 * 将json文本转换成json对象
	 * @param text
	 * @return
	 */
	public static JSONObject parseObject(String text){
		if(text == null && "".equals(text))
			return null;
		return JSON.parseObject(text);
	}
	
	/**
	 * 将json文本转换为javaBean
	 * @param text
	 * @param clazz
	 * @return
	 */
	public static <T> T parseObject(String text, Class<T> clazz){
		if(text == null && "".equals(text))
			return null;
		if(clazz == null && "".equals(clazz))
			return null;
		return JSON.parseObject(text, clazz);
	}
	
	/**
	 * 将json文本转换成JSONArray
	 * @param text
	 * @return
	 */
	public static JSONArray parseArray(String text){
		if(text == null && "".equals(text))
			return null;
		return JSON.parseArray(text);
	}
	
	/**
	 * 将json文本转换成javaBean集合
	 * @param text
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> parseArray(String text, Class<T> clazz){
		if(text == null && "".equals(text))
			return null;
		if(clazz == null && "".equals(clazz))
			return null;
		return JSON.parseArray(text, clazz);
	}
	
	/**
	 * 将javaBean转换成json文本
	 * @param object
	 * @return
	 */
	public static String toJSONString(Object object){
		if(object == null)
			return null;
		return JSON.toJSONString(object);
	}
	
	/**
	 * 将JavaBean转换成带格式的json文本
	 * @param object
	 * @param prettyFormat
	 * @return
	 */
	public static String toJSONString(Object object, boolean prettyFormat){
		if(object == null)
			return null;
		return JSON.toJSONString(object, prettyFormat);
	}
	
	/**
	 * 将JavaBean转换成JSONObject 或 JSONArray
	 * @param javaObject
	 * @return
	 */
	public static Object toJSON(Object javaObject){
		if(javaObject == null)
			return null;
		return JSON.toJSON(javaObject);
	}
	
}
