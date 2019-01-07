package pms;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.zs.pms.exception.AppException;
import com.zs.pms.po.ChannelPo;
import com.zs.pms.service.ChannelService;
import com.zs.pms.vo.ChannelQuery;

/**
 * 测试栏目
 * 
 * @author LXG
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestChannel {

	@Autowired
	ChannelService cs;

	//@Test //根据id查询数据
	public void testQueryById() {
		ChannelPo channel = cs.queryChannelById(2);
		System.out.println(channel.getCname());
	}

	// 多条件查询
	//@Test
	public void testQueryByCon() {
		ChannelQuery query = new ChannelQuery();
		query.setCname("西游记");
		// 声明文章实体
		ChannelPo channel;
		System.out.println(cs.queryChannelByCon(query).get(0).getId());
	}

	// 分页查询
	// @Test
	public void testQueryByPage() {
		ChannelQuery query = new ChannelQuery();
		List<ChannelPo> list = cs.queryChannelByPage(query, 1);

		for (ChannelPo channel : list) {
			System.out.println(channel);
		}
	}

	// 测试条数
	// @Test
	public void testQueryCount() {
		ChannelQuery query = new ChannelQuery();
		List<ChannelPo> list = cs.queryChannelByPage(query, 1);
		System.out.println("总页数为" + cs.queryByCount(query));
		for (ChannelPo channel : list) {
			System.out.println(channel);
		}
	}

	// 根据id删除数据
	// @Test
	public void testDel() {
		try {
			cs.deleteChannelById(7);
			System.out.println("根据id删除成功");
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.getErrcpde();
		}

	}

	// 批量删除数据
	// @Test
	public void testDels() {
		// 传入要删除的参数值，和数据库一致
		int[] id = { 8, 9 };
		// 执行批量删除条件
		try {
			cs.deletesChannel(id);
			System.out.println("批量删除成功");
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.getErrcpde();
		}
	}

	// 新增文章
	@Test
	public void testAdd() {
		// 创建对象
		ChannelPo channel = new ChannelPo();
		// 放入数据
		channel.setCname("李三光");
		channel.setPid(0);
		channel.setLev(1);
		channel.setIsleaf(1);
		channel.setSort(1);
		// 放入新增的方法
		try {
			cs.insertChannel(channel);
			System.out.println("新增成功");
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.getErrcpde();
		}
	}

	// 修改数据
	//@Test
	public void testUp() {
		// 创建对象
		ChannelPo channel = new ChannelPo();
		// 放入数据
		channel.setId(11);
		channel.setCname("黄种人");
		channel.setPid(12);
		channel.setLev(2);
		channel.setIsleaf(2);
		channel.setSort(2);

		try {
			cs.updateChannel(channel);
			System.out.println("修改成功");
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.getErrcpde();
		}

	}

}
