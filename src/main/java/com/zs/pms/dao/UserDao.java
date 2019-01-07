package com.zs.pms.dao;

import java.util.List;


import com.zs.pms.exception.AppException;
import com.zs.pms.po.TUser;
import com.zs.pms.vo.UserQuery;

public interface UserDao {
	//新增用户,返回主键
	public int 	insertUser(TUser user);
	//修改
	public void updateUser(TUser user);
	//删一条
	public void DeleteUser(int id);
	//分页查询
	public List<TUser> queryByPage(UserQuery query);
	//插条数
	public int queryCount(UserQuery query);
	//条件查询
	public List<TUser> queryByCon(UserQuery query)throws AppException;
	//根据ID查一条
	public TUser queryById(int id) throws AppException;
	//批量删除
	public void deletesUser(int[] id);
}
