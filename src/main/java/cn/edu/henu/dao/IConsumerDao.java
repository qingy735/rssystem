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
     * 根据消费者id查询消费者信息
     *
     * @param id
     * @return
     */
    Consumer getOneById(Integer id);

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
     */
    void add(Consumer consumer);
}
