package com.zs.pms.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zs.pms.utils.DateUtil;
/**
 * TUser表操作
 * @author Administrator
 *
 */
public class TUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5293214558214995122L;
	
	private int id;
	private String loginname;
	private String password;
	private String sex;
	private Date birthday;
	private String email;
	private TDep dept;//关联 tdep
	private String realname;
	private int creator;
	private Date creatime;
	private int updator;
	private Date updatime;
	private String pic;
	private int isenabled;
	//拥有的权限
	private List<TPermission> plist;
	//整理后的菜单
	private List<TPermission> menu= new ArrayList<TPermission>();
	
	private String birthdayTxt;
	private String enabledTxt;
	

	public String getBirthdayTxt() {
		return DateUtil.getStrDate(birthday);
	}


	public void setBirthdayTxt(String birthdayTxt) {
		this.birthdayTxt = birthdayTxt;
	}


	public String getEnabledTxt() {
		if (isenabled==1) {
			return "可用";
		}else {
			return "不可用";
		}
	}


	public void setEnabledTxt(String enabledTxt) {
		this.enabledTxt = enabledTxt;
	}


	public List<TPermission> getMenu(){
		//清空一级菜单
		menu.clear();
		//一级菜单
		for(TPermission per1:plist) {
			if (per1.getPid()==0) {
				//清空二级菜单
				per1.getChildren().clear();
				//二级菜单
				for(TPermission per2:plist) {
					if (per2.getPid()==per1.getId()) {
						per1.getChildren().add(per2);
					}
				}
				menu.add(per1);
			}
		}
		return menu;
	}
	
	
	public void setMenu(List<TPermission> menu) {
		this.menu = menu;
	}
	public List<TPermission> getPlist() {
		return plist;
	}
	public void setPlist(List<TPermission> plist) {
		this.plist = plist;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public TDep getDept() {
		return dept;
	}


	public void setDept(TDep dept) {
		this.dept = dept;
	}


	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public int getCreator() {
		return creator;
	}
	public void setCreator(int creator) {
		this.creator = creator;
	}
	public Date getCreatime() {
		return creatime;
	}
	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}
	public int getUpdator() {
		return updator;
	}
	public void setUpdator(int updator) {
		this.updator = updator;
	}
	public Date getUpdatime() {
		return updatime;
	}
	public void setUpdatime(Date updatime) {
		this.updatime = updatime;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public int getIsenabled() {
		return isenabled;
	}
	public void setIsenabled(int isenabled) {
		this.isenabled = isenabled;
	}
	
}
