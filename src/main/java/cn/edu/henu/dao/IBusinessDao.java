package cn.edu.henu.dao;

import java.util.List;

import cn.edu.henu.bean.Business;

/**
 * @author Qing_Y
 */
public interface IBusinessDao {
	/**
	 * 获取所有商家信息
	 * @return
	 */
	List<Business> getAllBusiness();
	
	/**
	 * 根据商家id查询商家信息
	 * @param id
	 * @return
	 */
	Business getOneById(Integer id);
	
	/**
	 * 根据商家id删除商家
	 * @param id
	 */
	void deleteById(Integer id);
	
	/**
	 * 修改商家信息
	 * @param business
	 */
	void update(Business business);
	
	/**
	 * 添加商家
	 * @param business
	 */
	void add(Business business);
}
