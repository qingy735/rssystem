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
     * 根据餐厅id和窗口id查询
     *
     * @param rid
     * @param wid
     * @return
     */
    Business getOneByRW(String rid, Integer wid);

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
    Integer add(Business business);
}
