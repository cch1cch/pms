package com.zs.pms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.TDep;
import com.zs.pms.po.TUser;
import com.zs.pms.service.DeptService;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.UserQuery;

@Controller
public class UserController {
	@Autowired
	UserService us;
	@Autowired
	DeptService ds;
	@RequestMapping("/user/toadd.do")
	public String toAdd(ModelMap map) {
		
		//加入一级部门
		map.addAttribute("dlist", ds.queryById(0));
		return "/user/add";
	}
	/**
	 * 用一级菜单的ID 去找下一菜单即 id=pid
	 * 这里拿到的pid 实际是一级菜单的ID
	 * @param pid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/user/getdept.do")	
	public List<TDep> getdept(int pid){
		
		return ds.queryById(pid);
	}
	
	
	/**
	 * 新增用户
	 * @return
	 */
	@RequestMapping("/user/add.do")
	public String add(TUser user,HttpSession session,ModelMap model) {
		TUser cu=(TUser) session.getAttribute("CUSER");
		//当前登录人
		user.setCreator(cu.getId());
		//可用
		user.setIsenabled(1);
		/*
		 * 部门固定
		 */
		
		try {
			us.insertUser(user);
			return "redirect:list.do";
		} catch (AppException e) {
			// TODO Auto-generated catch block
			model.addAttribute("msg", "新怎失败");
			return "/user/add";
		}
		
	}
	/*
	 * 分页显示
	 * 
	 */
	@RequestMapping("/user/list.do")
	public String list(UserQuery query,String page,ModelMap mode) {
		if (page==null||"".equals(page)) {
				page="1";
		}	
		//列表
		mode.addAttribute("list",us.queryByPage(query, Integer.parseInt(page)));
		//总页数
		mode.addAttribute("pagecount", us.queryCount(query));
		//当前页
		mode.addAttribute("page", page);
		mode.addAttribute("query", query);
		return "user/list";
	}
	@RequestMapping("/user/toupdate.do")
	public String get(int id, ModelMap map) {
		try {
			TUser user=us.queryById(id);
			user.setId(id);
			map.addAttribute("user", user);
			return "/user/update";
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	
	}
	@RequestMapping("user/update.do")
	public String update(int id,TUser user,HttpSession session,ModelMap map) {
		user.setId(id);//主键
		TUser cu=(TUser) session.getAttribute("CUSER");
		user.setUpdator(cu.getId());
		try {
			us.updateUser(user);
			return "redirect:list.do";
		} catch (AppException e) {
			// TODO Auto-generated catch block
			map.addAttribute("msg", e.getErrmsg());
			return this.get(id, map);
		}		
	}
	
	/*
	 * 删一条
	 */
	@RequestMapping("user/delete.do")
	public String delete( int id) {
		us.delete(id);
		return "redirect:list.do";
	}
	/**
	 * 删多条
	 */
	@RequestMapping("user/deletes.do")
	public String deletes(int[] ids) {
		us.deletes(ids);
		return "redirect:list.do";
	}
}
