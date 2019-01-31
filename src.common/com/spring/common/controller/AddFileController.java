package com.spring.common.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.base.controller.BaseController;
import com.spring.base.utils.ImageUtils;
import com.spring.common.service.impl.OSSFileUploadUtil;

@Controller
public class AddFileController extends BaseController {
	
	//图片格式验证
	public static final String[] imgSuffixs = { "png", "jpg", "gif","PNG", "JPG", "GIF", "JPEG", "jpeg","bmp" };

	/**
	 * 上传文件，包括图片
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add_file", method = RequestMethod.POST)
	public Map<String, Object> AddFile(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MultipartFile> file = new ArrayList<MultipartFile>();
		logger.error("file:"+file);
		try {
			ImageUtils.receiverPhoto(request, file);
			String getUploadImg = ImageUtils.uploadImage(file, request);
			logger.error("getUploadImg:"+getUploadImg);
			getUploadImg = imgPath + getUploadImg;
			map.put("code", 100);
			map.put("message", "上传成功");
			map.put("url", getUploadImg);
			return map;
		} catch (Exception e) {
			logger.error("[AddFileController --> add_file]:出错,错误原因:"
					+ e.getMessage());
			e.printStackTrace();
			map.put("code", "-101");
			map.put("message", "上传失败");
			return map;
		}
	}
	
	/**
	 * 上传图片至阿里云
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/add_file_aliyun")
	public Map<String, Object> addImage(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> result = new HashMap<>();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("uploadFile");
		// 获取上传路径
//		String realPath = request.getRealPath("/upload/image/");
//		String url = "/upload/image/";
//		// 如果文件夹不存在就新建一个文件夹
//		File dirPath = new File(realPath);
//		if (!dirPath.exists()) {
//			dirPath.mkdirs();
//		}

		// 设置响应给前台内容的数据格式
		response.setContentType("text/json; charset=UTF-8");
		// 设置响应给前台内容的PrintWriter对象
		// 上传文件的原名(即上传前的文件名字)
		String originalFilename = null;

		// 如果只是上传一个文件,则只需要MultipartFile类型接收文件即可,而且无需显式指定@RequestParam注解
		// 如果想上传多个文件,那么这里就要用MultipartFile[]类型来接收文件,并且要指定@RequestParam注解
		// 上传多个文件时,前台表单中的所有<input
		// type="file"/>的name都应该是myfiles,否则参数里的myfiles无法获取到所有上传的文件
		if (multipartFile.isEmpty()) {
			result.put("code", 1);
			result.put("message", "请选择文件后上传!");
			return result;
		} else if (multipartFile.getSize() > 20 * 1024 * 1024) {
			result.put("code", 1);
			result.put("message", "您上传的文件太大,系统允许最大文件20M!");
			return result;
		} else {
			// 获取文件名
			originalFilename = multipartFile.getOriginalFilename();

			// 文件名后缀处理---start---
			String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")+1, originalFilename.length());

			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			String newFileName = UUID.randomUUID().toString() +"."+ suffix;


			try {
//				url += newFileName;
//				String filePath = "/upload/image/"+newFileName;
//				File file = new File(realPath, newFileName);
				// 判断文件名是否是图片
				boolean isImage = false;
				for (int i = 0; i < imgSuffixs.length; i++) {
					if (suffix.toLowerCase().equals(imgSuffixs[i])) {
						isImage = true;
						break;
					}
				}

				if (isImage) {
					// 这里不必处理IO流关闭的问题,因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
					// 此处也可以使用Spring提供的MultipartFile.transferTo(File
					// dest)方法实现文件的上传
//					FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);// 上传文件

					String url = OSSFileUploadUtil.upload(multipartFile.getInputStream(), "image", newFileName);

					// 文件上传成功返回文件路径跟文件名
					result.put("code", 100);
					result.put("url", url);
					return result;
				} else {
					result.put("code", 0);
					result.put("message", "文件上传格式错误!");
					return result;
				}

			} catch (Exception e) {
				e.printStackTrace();
				result.put("code", 0);
				result.put("message", "文件上传出错!");
			}
		}
		return result;
	}
	
}
