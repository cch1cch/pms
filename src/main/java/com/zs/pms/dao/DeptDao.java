package com.zs.pms.dao;

import java.util.List;

import com.zs.pms.po.TDep;

public interface DeptDao {
	public List<TDep> queryById(int pid);
}
