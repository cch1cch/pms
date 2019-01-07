package pms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.service.UserService2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestUser2 {
	@Autowired
	UserService2 us;
	@Test
	public void testQuery() {
		
		System.out.println(us.queryByCon("test1").get(0).getRealname());
	}
}
