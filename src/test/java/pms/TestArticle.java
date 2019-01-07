package pms;
/**
 * 测试文章
 * @author LXG
 *
 */

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.ArticlePo;
import com.zs.pms.po.ChannelPo;

import com.zs.pms.service.ArticleService;
import com.zs.pms.vo.ArticleQuery;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestArticle {

	@Autowired
	ArticleService as;

	//根据id查询数据
	// @Test
	public void testQueryById() {
		ArticlePo article = as.queryById(1);
		System.out.println(article.getTitle());
	}

	// 多条件查询
	// @Test
	public void testQueryByCon() {
		ArticleQuery query = new ArticleQuery();
		query.setTitle("三打白骨精");
		query.setAuthor("吴承恩");

		// 声明文章实体
		ArticlePo article;

		try {
			System.out.println(as.queryArticleByCon(query).get(0).getContent());
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.getErrcpde();
		}
	}

	// 分页查询
	// @Test
	public void testQueryByPage() {
		ArticleQuery query = new ArticleQuery();
		List<ArticlePo> list = as.queryArticleByPage(query, 1);

		for (ArticlePo article : list) {
			System.out.println(article);
		}
	}

	// 测试条数
	// @Test
	public void testQueryCount() {
		ArticleQuery query = new ArticleQuery();
		List<ArticlePo> list = as.queryArticleByPage(query, 1);
		System.out.println("总页数为" + as.queryPageCount(query));
		for (ArticlePo article : list) {
			System.out.println(article);
		}
	}

	// 根据id删除数据
	// @Test
	public void testDel() {
		try {
			as.deleteArticle(9);
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
		int[] id = { 4, 10 };
		// 执行批量删除条件
		try {
			as.deletesArticle(id);
			System.out.println("批量删除成功");
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.getErrcpde();
		}
		
	}

	// 新增文章
	// @Test
	public void testAdd() {
		// 创建对象
		ArticlePo articlePo = new ArticlePo();
		// 放入数据
		articlePo.setTitle("无双");
		articlePo.setContent("周润发和郭富城领衔主演");
		articlePo.setAuthor("中国");
		articlePo.setCrtime(new Date());
		ChannelPo channel = new ChannelPo();
		channel.setId(1);
	//	articlePo.setChannel(channel);
		articlePo.setIsremod(1);
		articlePo.setIshot(1);

		// 放入新增的方法
		try {
			as.insertArticle(articlePo);
			System.out.println("新增成功");
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.getErrcpde();
		}
	}

	// 修改数据
	@Test
	public void testUp() {

		// 创建对象
		ArticlePo articlePo = new ArticlePo();
		articlePo.setId(1);
		// 放入数据
		articlePo.setTitle("天下无双");
		articlePo.setContent("韩信终于是出了他的大招天下无双，成功超神");
		articlePo.setAuthor("召唤师峡谷");
		articlePo.setCrtime(new Date());
		ChannelPo channel = new ChannelPo();
		channel.setId(1);
	//	articlePo.setChannel(channel);
		articlePo.setIsremod(1);
		articlePo.setIshot(1);
		
		try {
			as.updateArticle(articlePo);
			System.out.println("修改成功");
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.getErrcpde();
		}
	}
}
