package com.spring.api.config;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置参数类，各属性值在config.properties文件配置
 * Created by apple on 17/1/6.
 */
//@Configuration
public class TenYearsConfig {

	//redisson相关
//	@Value("${redis.ip}")
//	public String redisIp;
//	@Value("${redis.port}")
//	public String redisPort;
//	@Value("${redis.pass}")
//	public String redisPass;

	//阿里云oss上传相关appkey
	public static String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
	public static String accessKeyId = "LTAIOP2kZRM10QbE";
	public static String accessKeySecret = "H8K6U4vC0KQ3pWDtRVElQEaFTevSFE";
	public static String bucketName = "wenlvxingimage";
	public static String imageDomain = "http://wenlvxingimage.oss-cn-hangzhou.aliyuncs.com/";

//	@Bean
//	public RedissonClient redisson() {
//		Config config = new Config();
//		config.useSingleServer().setAddress(redisIp+":"+redisPort).setPassword(redisPass);
//	    return Redisson.create(config);
//	}

	@Value("#{config.oss_endpoint}")
	public static void setEndpoint(String endpoint) {
		TenYearsConfig.endpoint = endpoint;
	}

	@Value("#{config.oss_accessKeyId}")
	public static void setAccessKeyId(String accessKeyId) {
		TenYearsConfig.accessKeyId = accessKeyId;
	}

	@Value("#{config.oss_accessKeySecret}")
	public static void setAccessKeySecret(String accessKeySecret) {
		TenYearsConfig.accessKeySecret = accessKeySecret;
	}

	@Value("#{config.oss_bucketName}")
	public static void setBucketName(String bucketName) {
		TenYearsConfig.bucketName = bucketName;
	}

	@Value("#{config.oss_image_domain}")
	public static void setImageDomain(String imageDomain) {
		TenYearsConfig.imageDomain = imageDomain;
	}
}
