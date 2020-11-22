package cn.edu.henu.dao;

import java.util.List;

import cn.edu.henu.bean.Consumer;

/**
 * @author Qing_Y
 */
public interface IConsumerDao {

    /**
     * 获取所有消费者信息
     *
     * @return
     */
    List<Consumer> getAllCustomer();

    /**
     * 根据消费者username查询消费者信息
     *
     * @param username
     * @return
     */
    Consumer getOneByUsername(String username);

    /**
     * 根据消费者id删除消费者
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 修改消费者信息
     *
     * @param consumer
     */
    void update(Consumer consumer);

    /**
     * 添加消费者
     *
     * @param consumer
     * @return
     */
    boolean add(Consumer consumer);

    /**
     * 根据账号密码获取商家对象
     *
     * @param username
     * @param password
     * @return
     */
    Consumer getOneByLoginInfo(String username, String password);
}
