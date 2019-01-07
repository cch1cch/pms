package com.zs.pms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;

@Controller
public class FrameController {
	@RequestMapping("/top.do")
	public String top() {
		return "top";
	}
	@RequestMapping("/left.do")
	public String left(HttpSession session ,ModelMap model) {
		
		/**
		 * 加载权限菜单
		 */
		TUser us=(TUser) session.getAttribute("CUSER");
		List<TPermission> menu=us.getMenu();
		//带入left页面
		model.addAttribute("MENU", menu);
		return "left";
	}
	@RequestMapping("/right.do")
	public String right() {
		return "right";
	}
	
}
