package com.zs.pms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.pms.dao.DeptDao;
import com.zs.pms.po.TDep;
import com.zs.pms.service.DeptService;
@Service
public class DeptserviceImpl implements DeptService {
	@Autowired
	DeptDao da;

	@Override
	public List<TDep> queryById(int pid) {
		// TODO Auto-generated method stub
		
		return da.queryById(pid);
	}
	

}
