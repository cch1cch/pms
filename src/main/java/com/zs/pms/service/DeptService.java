package com.zs.pms.service;

import java.util.List;
import com.zs.pms.po.TDep;

public interface DeptService {
	public List<TDep> queryById(int pid);
}