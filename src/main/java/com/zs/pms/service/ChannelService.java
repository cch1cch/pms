package com.zs.pms.service;

import java.util.List;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.ChannelPo;
import com.zs.pms.vo.ArticleQuery;
import com.zs.pms.vo.ChannelQuery;

/**
 * 业务接口
 * 
 * @author LXG
 *
 */
public interface ChannelService {

	// 1、根据条件查询
	public List<ChannelPo> queryChannelByCon(ChannelQuery query);

	// 2、根据id进行查询
	public ChannelPo queryChannelById(int id);

	// 3、分页查询
	public List<ChannelPo> queryChannelByPage(ChannelQuery query, int page);

	// 4、查询条数
	public int queryByCount(ChannelQuery query);

	// 5、根据id进行删除
	public void deleteChannelById(int id) throws AppException;

	// 6、批量删除
	public int deletesChannel(int[] ids) throws AppException;

	// 7、新增数据
	public int insertChannel(ChannelPo po) throws AppException;

	// 8、修改数据
	public void updateChannel(ChannelPo po) throws AppException;
}
