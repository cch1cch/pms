package com.zs.pms.service;

import java.util.List;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.TUser;
import com.zs.pms.vo.UserQuery;

public interface UserService {
	public TUser queryByLogin(UserQuery query)throws AppException;
	public TUser queryById(int id)throws AppException;
	public List<TUser> queryByCon(UserQuery query)throws AppException;
	public void deletes(int[] id);
	public void delete(int id);
	public void updateUser(TUser user)throws AppException;
	public List<TUser> queryByPage(UserQuery query,int page);
	public int queryCount(UserQuery query);
	public void insertUser(TUser user)throws AppException;
}
