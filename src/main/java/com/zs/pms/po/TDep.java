package com.zs.pms.po;

import java.io.Serializable;

public class TDep implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6693929339309480899L;

	private int id;
	private String dname;
	private int pid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
}
