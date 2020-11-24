package cn.edu.henu.service;

import cn.edu.henu.bean.Business;

/**
 * @author Qing_Y
 */
public interface IBusinessService {

    /**
     * 登录验证
     *
     * @param username
     * @param password
     * @return
     */
    Business login(String username, String password);

    /**
     * 根据商家id删除商家
     *
     * @param id
     * @return
     */
    boolean deleteById(Integer id);

    /**
     * 修改商家信息
     *
     * @param business
     * @return
     */
    boolean update(Business business);

    /**
     * 添加商家
     *
     * @param business
     * @return
     */
    Integer save(Business business);
}
