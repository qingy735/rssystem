package cn.edu.henu.dao;

import cn.edu.henu.bean.Business;

/**
 * @author Qing_Y
 */
public interface IBusinessDao {

    /**
     * 根据商家id查询商家信息
     *
     * @param username
     * @return
     */
    Business getOneByUsername(String username);

    /**
     * 根据账号密码获取商家对象
     *
     * @param username
     * @param password
     * @return
     */
    Business getOneByLoginInfo(String username, String password);

    /**
     * 根据商家id删除商家
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 修改商家信息
     *
     * @param business
     */
    void update(Business business);

    /**
     * 添加商家
     *
     * @param business
     * @return
     */
    boolean add(Business business);
}
