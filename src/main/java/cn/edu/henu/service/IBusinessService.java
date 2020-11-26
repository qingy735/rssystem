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
     * 根据店铺username查询
     *
     * @param username 用户名
     * @return Business对象
     */
    Business getOneByKey(Integer username);

    /**
     * 添加商家
     *
     * @param business
     * @return
     */
    Integer save(Business business);
}
