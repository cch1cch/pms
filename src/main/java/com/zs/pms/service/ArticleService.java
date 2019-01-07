package com.zs.pms.service;

import java.util.List;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.ArticlePo;
import com.zs.pms.vo.ArticleQuery;



/**
 * 业务接口
 * @author LXG
 *
 */
public interface ArticleService {

	//根据id进行查询文章
	public ArticlePo queryById(int id);
	
	//根据条件查询
	public List<ArticlePo> queryArticleByCon(ArticleQuery query) throws AppException;
	
	//分页查询
	public List<ArticlePo> queryArticleByPage(ArticleQuery query, int page);
	
	//查询条数
	public int queryPageCount(ArticleQuery query); 
	
	//批量删除
	public int deletesArticle(int[] ids)throws AppException;
			
	//根据id进行删除
	public void deleteArticle(int id)throws AppException;
	
	//新增数据
	public int insertArticle(ArticlePo po) throws AppException;
			
	//修改数据
	public void updateArticle(ArticlePo po) throws AppException;
			
}
