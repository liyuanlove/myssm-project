package com.cn.winter.utils;

import java.util.HashMap;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.request.UploadFileRequest;
import com.qcloud.cos.sign.Credentials;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;


public class PicUploadToYun {

	public static String upload(String fileNewName,MultipartFile uploadFile) throws Exception {
		// 设置用户属性, 包括appid, secretId和SecretKey
		// 这些属性可以通过cos控制台获取(https://console.qcloud.com/cos)
		long appId = 1253516459;
		String secretId = "AKIDZ2KRludhKn4FHAGQo4B8xeBXwGPNalBQ";
		String secretKey = "CPWUJg8UhniS3TmuwmRvEOQK5jFcopfJ";
		// 设置要操作的bucket
		String bucketName = "part";
		// 初始化客户端配置
		ClientConfig clientConfig = new ClientConfig();






		// 设置bucket所在的区域，比如广州(gz), 天津(tj)
		clientConfig.setRegion("sh");
		// 初始化秘钥信息

		Credentials cred = new Credentials(appId, secretId, secretKey);
		// 初始化cosClient
		COSClient cosClient = new COSClient(clientConfig, cred);
		// 文件操作 //
		// 1. 上传文件(默认不覆盖)
		// 将本地的local_file_1.txt上传到bucket下的根分区下,并命名为sample_file.txt
		// 默认不覆盖, 如果cos上已有文件, 则返回错误
		String cosFilePath = "/mypart/"+fileNewName;
		byte[] localFilePath1 =  uploadFile.getBytes();
		UploadFileRequest uploadFileRequest = new UploadFileRequest(bucketName, cosFilePath, localFilePath1);
		uploadFileRequest.setEnableShaDigest(false);
		String uploadFileRet = cosClient.uploadFile(uploadFileRequest);
		System.out.println("upload file ret:" + uploadFileRet);
		//获取保存路径
		ObjectMapper om = new ObjectMapper();
		HashMap map = om.readValue(uploadFileRet, HashMap.class);
		HashMap<String, String> value = (HashMap<String, String>) map.get("data");
		return value.get("source_url");
	}
	
	public static void main(String[] args) throws Exception {
		//System.out.println(upload());
	}
}
