package com.zs.pms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.pms.dao.ChannelDao;
import com.zs.pms.exception.AppException;
import com.zs.pms.po.ChannelPo;
import com.zs.pms.service.ChannelService;
import com.zs.pms.utils.Constants;
import com.zs.pms.vo.ArticleQuery;
import com.zs.pms.vo.ChannelQuery;

/**
 * 
 * @author LXG
 *
 */
@Service // spring生成和数据库无关的对象
public class ChannelServiceImpl implements ChannelService {

	// 自动装配对象
	@Autowired
	ChannelDao dao;

	/**
	 * 多条件查询栏目数据
	 */
	@Override
	public List<ChannelPo> queryChannelByCon(ChannelQuery query) {
		// TODO Auto-generated method stub
		return dao.queryChannelByCon(query);
	}

	/**
	 * 根据id查询数据
	 */
	@Override
	public ChannelPo queryChannelById(int id) {
		// TODO Auto-generated method stub
		return dao.queryChannelById(id);
	}

	/**
	 * 分页查询
	 */
	@Override
	public List<ChannelPo> queryChannelByPage(ChannelQuery query, int page) {
		// TODO Auto-generated method stub
		// 根据页数算初始截止数
		// 起始,从0开始，需要加一
		int s = (page - 1) * Constants.SIZE + 1;
		// 截止
		int e = page * Constants.SIZE;
		query.setStart(s);
		query.setEnd(e);
		return dao.queryChannelByPage(query);
	}

	/**
	 * 查询总条数
	 */
	@Override
	public int queryByCount(ChannelQuery query) {
		// TODO Auto-generated method stub
		// 总条数
		int count = dao.queryByCount(query);

		// 是每条页数的倍数。例如条数定死5，共有20条，就有4页
		if (count % Constants.SIZE == 0) {
			return count / Constants.SIZE;
		}
		// 有余数则把剩余的分到下一页
		else {
			return count / Constants.SIZE + 1;
		}

	}

	/**
	 * 根据id删除
	 */
	@Override
	public void deleteChannelById(int id) throws AppException {
		// TODO Auto-generated method stub
		dao.deleteChannelById(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public int deletesChannel(int[] ids) throws AppException {
		// TODO Auto-generated method stub
		return dao.deletesChannel(ids);
	}

	/**
	 * 新增数据
	 */
	@Override
	public int insertChannel(ChannelPo po) throws AppException {
		// TODO Auto-generated method stub
		/*//抛异常
		if (po.getId()!=0) {
			throw new AppException(1001, "该编号已存在");
		}
		if (po.getCname()!=null ) {
			throw new AppException(1002, "栏目名称已存在");
		}*/
		// 添加主键
		dao.insertChannel(po);
		// 返回主键
		return po.getId();
	}

	/**
	 * 修改数据
	 */
	@Override
	public void updateChannel(ChannelPo po) throws AppException {
		// TODO Auto-generated method stub
		//抛异常
		/*if (po.getId()!=0) {
			throw new AppException(1001, "该编号已存在");
		}
		if (po.getCname()!=null ) {
			throw new AppException(1002, "栏目名称已存在");
		}*/
		dao.updateChannel(po);
	}
}
