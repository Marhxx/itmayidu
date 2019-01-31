package com.spring.common.service.impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;
import com.spring.api.config.TenYearsConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 阿里云oss文件上传工具类
 * Created by apple on 17/1/6.
 */
public class OSSFileUploadUtil {


	/**
	 * 上传文件
	 * @param file 需要上传的文件
	 * @return 文件相对地址
	 */
	public static String upload(File file) throws Exception{
		return upload(file, "image");
	}

	/**
	 *
	 * @param file 需要上传的文件
	 * @param folder 保存到哪个目录下
	 * @return 文件相对地址
	 */
	public static String upload(File file, String folder) throws Exception{
		// 获取文件名
		String originalFilename = file.getName();
		// 文件名后缀处理
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
		String fileName = UUID.randomUUID().toString().replace("-", "")+suffix;
		return upload(new FileInputStream(file), folder, fileName);
	}

	public static String upload(InputStream inputStream, String folder, String fileName) throws Exception{

		String relativeUrl = "upload/"+folder+"/"+fileName;
		
		OSSClient ossClient = new OSSClient(TenYearsConfig.endpoint, TenYearsConfig.accessKeyId, TenYearsConfig.accessKeySecret);
		try {
			ObjectMetadata meta = new ObjectMetadata();
			ObjectMetadata objectMetadata = new ObjectMetadata();
			objectMetadata.setContentLength(inputStream.available());
			objectMetadata.setCacheControl("no-cache");
			objectMetadata.setHeader("Pragma", "no-cache");
			objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
			objectMetadata.setContentDisposition("inline;filename="+fileName);
			// 上传文件
			ossClient.putObject(TenYearsConfig.bucketName, relativeUrl, inputStream, meta);
			// 获取文件的元信息
//			ObjectMetadata metadata = ossClient.getObjectMetadata(bucketName, relativeUrl);
//          ossClient.deleteObject(bucketName, key);
		} finally {
			ossClient.shutdown();
		}

		return TenYearsConfig.imageDomain+relativeUrl;
	}

	public static String getcontentType(String FilenameExtension) {
		if (FilenameExtension.equalsIgnoreCase("bmp")) {
			return "image/bmp";
		}
		if (FilenameExtension.equalsIgnoreCase("gif")) {
			return "image/gif";
		}
		if (FilenameExtension.equalsIgnoreCase("jpeg") ||
				FilenameExtension.equalsIgnoreCase("jpg") ||
				FilenameExtension.equalsIgnoreCase("png")) {
			return "image/jpeg";
		}
		if (FilenameExtension.equalsIgnoreCase("html")) {
			return "text/html";
		}
		if (FilenameExtension.equalsIgnoreCase("txt")) {
			return "text/plain";
		}
		if (FilenameExtension.equalsIgnoreCase("vsd")) {
			return "application/vnd.visio";
		}
		if (FilenameExtension.equalsIgnoreCase("pptx") ||
				FilenameExtension.equalsIgnoreCase("ppt")) {
			return "application/vnd.ms-powerpoint";
		}
		if (FilenameExtension.equalsIgnoreCase("docx") ||
				FilenameExtension.equalsIgnoreCase("doc")) {
			return "application/msword";
		}
		if (FilenameExtension.equalsIgnoreCase("xml")) {
			return "text/xml";
		}
		return "image/jpeg";
	}

//	public static void main(String[] args) throws Exception {
//		String fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".jpg";
//		String file = "/Users/apple/Desktop/20161229151714_2.jpg";
//		String path = upload(new File(file), "image");
//		System.out.println(path);
//	}

}
