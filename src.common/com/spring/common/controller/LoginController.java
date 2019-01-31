package com.spring.common.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.base.controller.BaseController;
import com.spring.base.utils.CaptchaUtils;
import com.spring.base.utils.GlobalStatic;
import com.spring.base.utils.StringTool;
import com.spring.common.entity.Userinfo;
import com.spring.common.service.UserinfoService;

@Controller
public class LoginController extends BaseController {
	
	@Resource UserinfoService userinfoService;

	@RequestMapping(value="/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginAuth(HttpSession session,HttpServletRequest request,Model model) {
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String submitCode = request.getParameter("code");
		Userinfo searchParams = new Userinfo();
		searchParams.setAccount(account);
		String code = (String) session.getAttribute(GlobalStatic.DEFAULT_CAPTCHA_PARAM);
		if (StringUtils.isNotBlank(code)) {
			code = code.toLowerCase().toString();
		}
		if (StringUtils.isNotBlank(submitCode)) {
			submitCode = submitCode.toLowerCase().toString();
		}

		if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
			model.addAttribute("message", "请输入用户名和密码！");
			return "/login";
		}

//		if (StringUtils.isBlank(submitCode) || StringUtils.isBlank(code)
//				|| !code.equals(submitCode)) {
//			model.addAttribute("message", "验证码错误!");
//			return "/login";
//		}
		Userinfo userinfo = userinfoService.findUserinfo(searchParams);
		if (userinfo == null
				|| !userinfo.getPassword().equals(
						StringTool.md5(password).toUpperCase())) {
			model.addAttribute("message", "用户名或密码错误!");
			return "/login";
		}
		model.addAttribute(userinfo);
		session.setAttribute(GlobalStatic.DEFAULT_LOGIN_SESSION_NAME,userinfo);
		
		UsernamePasswordToken token = new UsernamePasswordToken(userinfo.getAccount(), userinfo.getPassword());
		Subject user = SecurityUtils.getSubject();
		user.login(token);
		return "redirect:/index";
	}
	
	/**
	 * 生成验证码
	 * 
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/getCaptcha")
	public void getCaptcha(HttpSession session,HttpServletResponse response) throws IOException {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);

		CaptchaUtils tool = new CaptchaUtils();
		StringBuffer code = new StringBuffer();
		BufferedImage image = tool.genRandomCodeImage(code);
		session.removeAttribute(GlobalStatic.DEFAULT_CAPTCHA_PARAM);
		session.setAttribute(GlobalStatic.DEFAULT_CAPTCHA_PARAM, code.toString());
		// 将内存中的图片通过流动形式输出到客户端
		ImageIO.write(image, "JPEG", response.getOutputStream());
		return;
	}
	
}
