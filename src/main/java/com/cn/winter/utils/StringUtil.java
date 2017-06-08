package com.cn.winter.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 
 * 字符串工具类
 * @author Administrator
 *
 */
public class StringUtil {

	
	/**
	 * 密码加密方法
	 * @param data
	 * @return
	 */
	public static String md5(String data) {
		String _date = org.apache.commons.codec.digest.DigestUtils.md5Hex(data);
		return _date;
	}
	
	/**
	 * 主键生成方法
	 * @return
	 */
	public static String uuid() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		// 去掉"-"符号
		String temp;
		temp = str.replaceAll("-", "");
		return temp;
	}
	
	/**
	 * 文件上传，为文件重新命名
	 **/
	public static String getFileRename(String name) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String sdfDate = sdf.format(date);
        int pos = name.lastIndexOf(".");
        String suffix = name.substring(pos);
        String rename = sdfDate+suffix;
        return rename;
    }
}
