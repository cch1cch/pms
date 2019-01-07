package com.zs.pms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zs.pms.dao.UserDao;
import com.zs.pms.exception.AppException;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.utils.Constants;
import com.zs.pms.utils.MD5;
import com.zs.pms.vo.UserQuery;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao dao;
	//登录
	@Override
	public TUser queryByLogin(UserQuery query) throws AppException {
		// TODO Auto-generated method stub
		if (!"".equals(query.getPassword())) {
			MD5 md5=new MD5();
			String pwd=md5.getMD5ofStr(query.getPassword());
			query.setPassword(pwd);
		}
		List<TUser> users=dao.queryByCon(query);		
		if (users==null || users.size()!=1) {
			throw new AppException(1000, "用户名或密码错误");
		}
		TUser user2=dao.queryById(users.get(0).getId());
		if (user2==null) {
			throw new AppException(1002, "无权限或数据异常");
		}
		return user2;
	}
	//安ID查
	@Override
	public TUser queryById(int id) throws AppException {
		// TODO Auto-generated method stub
		TUser user=dao.queryById(id);
		if (user==null) {
			throw new AppException(1001, "次ID不存在用户"); 
		}
		return user;
	}
	//条件查询
	@Override
	public List<TUser> queryByCon(UserQuery query) throws AppException {
		// TODO Auto-generated method stub
		return dao.queryByCon(query);
	}
	//删除
	@Override
	public void deletes(int[] id) {
		// TODO Auto-generated method stub
		dao.deletesUser(id);
	}
	//修改
	@Override
	public void updateUser(TUser user)throws AppException {
		// TODO Auto-generated method stub
			if (user.getPassword() == null || user.getPassword().length() <= 4) {
			throw new AppException(1004, "用户密码不得少于6位 ");
		}
		/*
		 * 明码变密码 
		 * 
		 */
		//如果数据库中的密码不等于页面上传过来的密码则密码改变了，需要加密
		if (!((dao.queryById(user.getId()).getPassword()).equals(user.getPassword()))) {
			MD5 md5 = new MD5();
			// 加密后的密码
			String pwd = md5.getMD5ofStr(user.getPassword());
			user.setPassword(pwd);
		}

		dao.updateUser(user);
	}
	//分页
	@Override
	public List<TUser> queryByPage(UserQuery query, int page) {
		// TODO Auto-generated method stub
		int s=(page-1)*Constants.SIZE+1;
		int e=page*Constants.SIZE;
		query.setStart(s);
		query.setEnd(e);
		return dao.queryByPage(query);
	}
	//	返回总页数
	@Override
	public int queryCount(UserQuery query) {
		// TODO Auto-generated method stub
		int count=dao.queryCount(query);
		if (count%Constants.SIZE==0) {
			return count/Constants.SIZE;
		}
		else {
			return count/Constants.SIZE+1;
		}
	}
	/**
	 * 新增
	 */
	@Override
	public void insertUser(TUser user) throws AppException {
		// TODO Auto-generated method stub
		if (!"".equals(user.getPassword())) {
			MD5 md5=new MD5();
			String pwd=md5.getMD5ofStr(user.getPassword());
			user.setPassword(pwd);
		}
			dao.insertUser(user);
	}
	/**
	 * 删一条
	 */
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.DeleteUser(id);
	}

	
}
