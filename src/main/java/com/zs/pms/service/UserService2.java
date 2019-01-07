package com.zs.pms.service;

import java.util.List;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.TUser;
import com.zs.pms.vo.UserQuery;

public interface UserService2 {
	public List<TUser> queryByCon(String name);

}
