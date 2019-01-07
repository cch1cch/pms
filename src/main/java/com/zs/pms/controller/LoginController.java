package com.zs.pms.controller;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.utils.DateUtil;
import com.zs.pms.vo.UserQuery;
/**
 * 用户登录
 * @author Administrator
 *
 */

@Controller
public class LoginController {
	//掉业务方法
	@Autowired
	UserService us;
	//前往登录页面
	@RequestMapping("/tologin.do")
	public String tologin() {
		return "login";		
	}
	//登录方法
	@RequestMapping("/login.do")
	public String login(String rmbpwd,String idenfitying, 
			ModelMap model,UserQuery query,HttpSession session,HttpServletResponse response) {	
		// 判断是否勾选
		if (rmbpwd != null && rmbpwd.equals("1")) {
			// 利用cookie记住密码和账号
			Cookie cookie1 = new Cookie("loginname", query.getLoginname());
			Cookie cookie2 = new Cookie("password", query.getPassword());
			// 设置Cookie有效时间
			cookie1.setMaxAge(60);
			cookie2.setMaxAge(60);
			// 给响应
			response.addCookie(cookie1);
			response.addCookie(cookie2);
		}					
		// 调用方法
		try {
			TUser user = us.queryByLogin(query);
			//从session中获取图片中的验证码
			String code=(String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
			//判断
			if (!idenfitying.equals(code)) {
				model.addAttribute("msg", "验证码错误，请重新输入");			
				return  "login";
			}
			// 放值进session
			session.setAttribute("CUSER", user);
			session.setAttribute("TODAY", DateUtil.getStrDate(new Date()));
			return "main";
		} catch (AppException e) {
			model.addAttribute("msg", e.getErrmsg());						
			return "login";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		
	
	}
}
