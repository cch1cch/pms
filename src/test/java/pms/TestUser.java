package pms;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.TDep;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.UserQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestUser {
	@Autowired
	UserService us;
	
	public void testLogin() {
		UserQuery query=new UserQuery();
		query.setLoginname("test1");
		query.setPassword("1234");
		TUser user;
		try {
			user=us.queryByLogin(query);
			System.out.println(user.getRealname()+"权限：");
			for(TPermission p:user.getPlist()) {
				System.out.println(p.getPname());
			}
			System.out.println("-----------整理后菜单-----------");
			for(TPermission p:user.getMenu()) {
				System.out.println(p.getPname());
				for(TPermission p2:p.getChildren()) {
					System.out.println("  ---"+p2.getPname());
				}
			}
		} catch (AppException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getErrmsg());
		}
	}
	public void testDelete() {
		int[] id= {1,2,3};
		us.deletes(id);
	}
	
	public void testUpdate() {
		TUser user=new TUser();
		user.setId(3100);
		user.setLoginname("test4");
		TDep dep=new TDep();
		dep.setId(6);
		user.setDept(dep);
		try {
			us.updateUser(user);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testPage() {
		UserQuery query=new UserQuery();
		query.setSex("男");
		List<TUser> list=us.queryByPage(query, 1);
		int i=us.queryCount(query);
		for(TUser user:list) {
			System.out.println(user.getId()+"-----------"+i);
		}
		
	}
	
	public void testqueryid() {
		try {
			TUser user=us.queryById(3084);
			System.out.println(user.getId());
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
