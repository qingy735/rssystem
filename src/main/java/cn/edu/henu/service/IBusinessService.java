package cn.edu.henu.service;

import java.util.List;

import cn.edu.henu.bean.Business;
import org.springframework.stereotype.Service;

/**
 * @author Qing_Y
 */
public interface IBusinessService {
	/**
	 * 获取所有商家信息
	 * @return
	 */
	List<Business> getAllBusiness();
	
	/**
	 * 登录验证
	 * @param business
	 * @return
	 */
	Boolean login(Business business);
	
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
