package com.zs.pms.exception;

public class AppException extends Exception{
	private int errcpde;
	private String errmsg;
	public AppException(int errcpde, String errmsg) {
		this.errcpde = errcpde;
		this.errmsg = errmsg;
	}
	public int getErrcpde() {
		return errcpde;
	}
	public void setErrcpde(int errcpde) {
		this.errcpde = errcpde;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
}
