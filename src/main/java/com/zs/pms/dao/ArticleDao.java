package com.zs.pms.dao;

import java.util.List;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.ArticlePo;
import com.zs.pms.vo.ArticleQuery;

/**
 * 文章数据操作对象
 * 
 * @author LXG
 *
 */
public interface ArticleDao {

	// 1、根据条件查询
	public List<ArticlePo> queryArticleByCon(ArticleQuery query);

	// 2、根据id进行查询
	public ArticlePo queryArticleById(int id);

	// 3、分页查询
	public List<ArticlePo> queryArticleByPage(ArticleQuery query);

	// 4、查询条数
	public int queryByCount(ArticleQuery query);

	// 5、根据id进行删除
	public void deleteArticleById(int id) throws AppException;

	// 6、批量删除
	public int deletesArticle(int[] ids) throws AppException;

	// 7、新增数据
	public int insertArticle(ArticlePo po) throws AppException;

	// 8、修改数据
	public void updateArticle(ArticlePo po) throws AppException;

}
