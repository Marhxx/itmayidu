/**    
* @{#} TbInformationCataController.java Create on 2015年8月26日 下午4:11:42    
* Copyright (c) 2015.    
*/
package com.spring.common.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.base.controller.BaseController;
import com.spring.base.utils.StringUtil;
import com.spring.common.entity.TbVersion;
import com.spring.common.service.TbVersionService;

/**
 * @author lcx
 * @version 1.0
 * @description
 */
@Controller
@RequestMapping(value = "/version")
public class TbVersionController extends BaseController {

	@Resource
	TbVersionService tbVersionService;
	/**
	 * 获取最新版本
	 * @param type
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/app",method=RequestMethod.POST)
	public Map<String, Object> findVersionByType(String type){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = null;
		
		//参数验证
		if(StringUtil.isEmptyNull(type)){//不同app端对应不同type
			map.put("code", 102);
			map.put("message", "参数提交不完整");
			return map;
		}
//		else if(!"1".equals(type)&&!"2".equals(type)&&!"3".equals(type)){
//			map.put("code", -1);
//			map.put("message", "验证不通过");
//			return map;
//		}
		
		try {
			list = tbVersionService.findVersionByType(type);
			if(list.size()==0){
				map.put("code", "199");
				map.put("message", "暂无数据");
				return map;
			}
			map.put("code", 100);
			map.put("message", "查询成功");
			map.put("info", list.get(0));
			return map;
		} catch (Exception e) {
			logger.error("[TbVersionController --> findVersionByType]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			map.put("code", -101);
			map.put("message", "查询失败");
			return map;
		}
	}

//	@RequestMapping(method = RequestMethod.POST, value = "/upload")
//	@ResponseBody
//	public String imageUpload(HttpServletRequest request, @RequestParam("file_upload") MultipartFile file_upload) {
//
//	//	String uploadDir = PropertiesUtil.getProperty("upload_path", "config") + "/appver/";
////		String uploadDir = request.getRealPath("/upload/update/appver/");
//		
////		System.out.println("uploadDir:" + uploadDir);
//		// String uploadDir = request.getRealPath("/PocketMoney/upload/ad/");
////		File dirPath = new File(uploadDir);
////		if (!dirPath.exists()) {
////			dirPath.mkdirs();
////		}
//		// 获取从前台传来的文件名
//		String oriName = file_upload.getOriginalFilename();
//		// 文件名后缀处理---start---
//		String suffix = oriName.substring(oriName.lastIndexOf("."), oriName.length());
////		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
////		String newFileName = df.format(new Timestamp(System.currentTimeMillis())) + "_" + new Random().nextInt(5)
////				+ suffix;
//		String newFileName = UUID.randomUUID().toString() + suffix;
////		File file = new File(uploadDir + "/" + newFileName);
////		BufferedImage bi;
////		int srcWidth = 0, srcHeight = 0;
//		String url = "";
//		try {
//			// addfileimage.transferTo(new File(uploadDir + "/" + newFileName));
////			FileUtils.copyInputStreamToFile(file_upload.getInputStream(), file);
//			url = OSSFileUploadUtil.upload(file_upload.getInputStream(), "appver", newFileName);
////			System.out.println("路径:" + uploadDir + "/" + newFileName);
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
////		StringBuffer json = new StringBuffer("{\"path\":\"" + baseUrl + "/upload/update/appver/");
////		json.append(newFileName + "\",").append("\"filename\":").append("\"" + oriName + "\"}");
//		StringBuffer json = new StringBuffer("{\"path\":\"" + imgPrefix + url+ "\",");
//		json.append("\"filename\":").append("\"" + oriName + "\"}");
//		System.err.println(json.toString());
//		return json.toString();
//	}
	@RequestMapping(method = RequestMethod.POST, value = "/upload")
	@ResponseBody
	public String imageUpload(HttpServletRequest request, @RequestParam("file_upload") MultipartFile file_upload) {

	//	String uploadDir = PropertiesUtil.getProperty("upload_path", "config") + "/appver/";
		String uploadDir = request.getRealPath("/upload/update/appver/");
		
		System.out.println("uploadDir:" + uploadDir);
		// String uploadDir = request.getRealPath("/PocketMoney/upload/ad/");
		File dirPath = new File(uploadDir);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
		// 获取从前台传来的文件名
		String oriName = file_upload.getOriginalFilename();
		// 文件名后缀处理---start---
		String suffix = oriName.substring(oriName.lastIndexOf("."), oriName.length());
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String newFileName = df.format(new Timestamp(System.currentTimeMillis())) + "_" + new Random().nextInt(5)
				+ suffix;
		File file = new File(uploadDir + "/" + newFileName);
		BufferedImage bi;
		int srcWidth = 0, srcHeight = 0;

		try {
			// addfileimage.transferTo(new File(uploadDir + "/" + newFileName));
			FileUtils.copyInputStreamToFile(file_upload.getInputStream(), file);
			System.out.println("路径:" + uploadDir + "/" + newFileName);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		StringBuffer json = new StringBuffer("{\"path\":\"" + baseUrl + "/upload/update/appver/");
		json.append(newFileName + "\",").append("\"filename\":").append("\"" + oriName + "\"}");
		System.err.println(json.toString());
		return json.toString();
	}
}
