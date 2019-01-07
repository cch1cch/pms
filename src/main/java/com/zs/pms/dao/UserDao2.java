package com.zs.pms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.zs.pms.po.TUser;

@Repository
public interface UserDao2 {
	//条件查询
	@Select("select * from tuser where loginname=#{loginname}")
	public List<TUser> queryByCon(String name);

}
