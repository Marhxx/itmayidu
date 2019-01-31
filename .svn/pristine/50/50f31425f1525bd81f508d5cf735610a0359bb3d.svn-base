package com.spring.base.utils;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Callback;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.spring.api.config.HttpUtilS;
import com.spring.base.controller.BaseController;

public final class ImageUtils{
	/**
	 * 图片水印
	 * @param pressImg 水印图片
	 * @param targetImg 目标图片
	 * @param x 修正值 默认在中间
	 * @param y 修正值 默认在中间
	 * @param alpha 透明度
	 */
	public final static void pressImage(String pressImg, String targetImg, int x, int y, float alpha) {
		try {
			File img = new File(targetImg);
			Image src = ImageIO.read(img);
			int wideth = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			g.drawImage(src, 0, 0, wideth, height, null);
			//水印文件
			Image src_biao = ImageIO.read(new File(pressImg));
			int wideth_biao = src_biao.getWidth(null);
			int height_biao = src_biao.getHeight(null);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			g.drawImage(src_biao, (wideth - wideth_biao) / 2, (height - height_biao) / 2, wideth_biao, height_biao, null);
			//水印文件结束
			g.dispose();
			ImageIO.write((BufferedImage) image, "jpg", img);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 文字水印
	 * @param pressText 水印文字
	 * @param targetImg 目标图片
	 * @param fontName 字体名称
	 * @param fontStyle 字体样式
	 * @param color 字体颜色
	 * @param fontSize 字体大小
	 * @param x 修正值
	 * @param y 修正值
	 * @param alpha 透明度
	 */
	public static void pressText(String pressText, String targetImg, String fontName, int fontStyle, Color color, int fontSize, int x, int y, float alpha) {
		try {
			File img = new File(targetImg);
			Image src = ImageIO.read(img);
			int width = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			g.drawImage(src, 0, 0, width, height, null);
			g.setColor(color);
			g.setFont(new Font(fontName, fontStyle, fontSize));
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			g.drawString(pressText, (width - (getLength(pressText) * fontSize)) / 2 + x, (height - fontSize) / 2 + y);
			g.dispose();
			ImageIO.write((BufferedImage) image, "jpg", img);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 缩放
	 * @param filePath 图片路径
	 * @param height 高度
	 * @param width 宽度
	 * @param bb 比例不对时是否需要补白
	 */
	@SuppressWarnings("static-access")
	public static void resize(String filePath, int height, int width, boolean bb) {
		try {
			double ratio = 0.0; //缩放比例 
			File f = new File(filePath);
			BufferedImage bi = ImageIO.read(f);
			Image itemp = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);
			//计算比例
			if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
				if (bi.getHeight() > bi.getWidth()) {
					ratio = (new Integer(height)).doubleValue() / bi.getHeight();
				} else {
					ratio = (new Integer(width)).doubleValue() / bi.getWidth();
				}
				AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
				itemp = op.filter(bi, null);
			}
			if (bb) {
				BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics2D g = image.createGraphics();
				g.setColor(Color.white);
				g.fillRect(0, 0, width, height);
				if (width == itemp.getWidth(null))
					g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2, itemp.getWidth(null), itemp.getHeight(null), Color.white, null);
				else
					g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0, itemp.getWidth(null), itemp.getHeight(null), Color.white, null);
				g.dispose();
				itemp = image;
			}
			ImageIO.write((BufferedImage) itemp, "jpg", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		pressImage("G:\\imgtest\\sy.jpg", "G:\\imgtest\\test1.jpg", 0, 0, 0.5f);
		pressText("我是文字水印", "D:/error.jpg", "黑体", 36, Color.white, 80, -10, 0, 0.3f);
		resize("G:\\imgtest\\test1.jpg", 500, 500, true);
	}

	public static int getLength(String text) {
		int length = 0;
		for (int i = 0; i < text.length(); i++) {
			if (new String(text.charAt(i) + "").getBytes().length > 1) {
				length += 2;
			} else {
				length += 1;
			}
		}
		return length / 2;
	}
	
	/**
	 * 
	* @Title: receiverPhoto 
	* @Description:  用来接收客户端发送过来的图片文件
	* @param @param request
	* @param @param thfPhoto    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static void receiverPhoto(HttpServletRequest request,
			List<MultipartFile> photo) {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					// 如果名称不为空,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						photo.add(file);
					}
				}
			}
		}
	}

	/**
	 * 上传图片
	 * 
	 * @param thwPhoto
	 * @param request
	 * @return
	 */
	public static String uploadImage(List<MultipartFile> photo,
			HttpServletRequest request) {
		String realPath = request.getRealPath("/upload/file");
//		String imgPath = "http://hjtech.wicp.net:8080/rabbit-api";
//		String BasePath = imgPath;
//		System.out.println("imgPath:"+imgPath);
		String url = "/upload/file/";
		String returnMsg = "";
		int i = 0;
		for (MultipartFile myfile : photo) {
			i++;
			if (myfile.isEmpty()) {
				returnMsg = "";
			} 
//			else if (myfile.getSize() > 2 * 1024 * 1024) {
//				return "error";
//			} 
			else {
				// 获取文件名
				String originalFilename = myfile.getOriginalFilename();
				// 文件名后缀处理
				String suffix = originalFilename.substring(
						originalFilename.lastIndexOf("."),
						originalFilename.length());
				
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				String newFileName = "file-"+df.format(new Timestamp(System
						.currentTimeMillis())) + suffix;
				String realUrl = url + newFileName;
				File file = new File(realPath, newFileName);
				try {
					// 判断文件名是否是图片
					FileUtils.copyInputStreamToFile(
							myfile.getInputStream(), file);// 上传文件到磁盘
					returnMsg += realUrl;
//					returnMsg = BasePath + returnMsg;
//					if (".jpg".equals(suffix) || ".gif".equals(suffix)
//							|| ".png".equals(suffix)) {
//						
//					} else {
//						return "error";
//					}
				} catch (IOException e) {
					System.out.println("文件[" + newFileName + "]上传失败,堆栈轨迹如下");
					e.printStackTrace();
					return "error";
				}
			}
		}
		return returnMsg;
	}
	
	
	/**
	 * 下载服务器上的文件到本地客服端
	 * @param theURL	服务器
	 * @param filePath	本地客服端
	 * @throws IOException
	 */
	 public static void downloadFile(URL theURL, String filePath) throws IOException {  
		   File dirFile = new File(filePath);
		      if(!dirFile.exists()){ 
		        //文件路径不存在时，自动创建目录
		        dirFile.mkdir();
		      }
		  //从服务器上获取图片并保存
		     URLConnection connection = theURL.openConnection();
		     InputStream in = connection.getInputStream();  
		     FileOutputStream os = new FileOutputStream(filePath+"\\文件名.png"); 
		     byte[] buffer = new byte[4 * 1024];  
		     int read;  
		     while ((read = in.read(buffer)) > 0) {  
		        os.write(buffer, 0, read);  
		          }  
		       os.close();  
		       in.close();
		  }   
}
