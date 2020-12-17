package cn.edu.henu.dao;

import cn.edu.henu.bean.*;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-12-07 23:08
 */
public interface AdminMapper {

    /**
     * 根据用户名查找
     *
     * @param username
     * @return
     */
    Admin selectByPrimarykey(String username);

    /**
     * 查询所有订单
     *
     * @return
     */
    List<Order> selectAllOrder();

    /**
     * 根据条件查询所有订单
     *
     * @return
     */
    List<Order> selectOrderByCon(Order order);

    /**
     * 查询所有评论
     *
     * @return
     */
    List<Comment> selectAllComment();

    /**
     * 查询所有商家
     *
     * @return
     */
    List<Business> selectAllBusiness();

    /**
     * 查询所有店铺信息
     *
     * @param business
     * @return
     */
    List<Business> selectBusinessByCon(Business business);

    /**
     * 查询所有消费者信息
     *
     * @return
     */
    List<Consumer> selectAllConsumer();

    /**
     * 查询所有符合条件的消费者
     *
     * @param consumer
     * @return
     */
    List<Consumer> selectConsumerByCon(Consumer consumer);

    /**
     * 查询符合条件有多少订单
     *
     * @param order
     * @return
     */
    int selectOrderTotal(Order order);

    /**
     * 查询符合条件有多少商家
     *
     * @param business
     * @return
     */
    int selectBusinessTotal(Business business);

    /**
     * 查询符合条件有多少消费者
     *
     * @param consumer
     * @return
     */
    int selectConsumerTotal(Consumer consumer);
}
