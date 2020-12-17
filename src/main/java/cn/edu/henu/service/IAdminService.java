package cn.edu.henu.service;

import cn.edu.henu.bean.*;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-12-07 23:18
 */
public interface IAdminService {
    /**
     * 登录功能
     *
     * @param admin
     * @return
     */
    Boolean login(Admin admin);

    /**
     * 分页查询所有订单
     *
     * @param order
     * @param row
     * @return
     */
    PageBean<Order> findAllOrderByPage(Order order, Integer row);

    /**
     * 查询所有评论
     *
     * @return
     */
    List<Comment> findAllComment();

    /**
     * 根据条件查询所有店铺信息
     *
     * @param business
     * @param row
     * @return
     */
    PageBean<Business> findAllBusinessByPage(Business business, Integer row);

    /**
     * 查询所有消费者信息
     *
     * @param consumer
     * @param row
     * @return
     */
    PageBean<Consumer> findAllConsumerByPage(Consumer consumer, Integer row);

    /**
     * 查询有多少
     *
     * @param order
     * @return
     */
    int getOrderTotal(Order order);

    /**
     * 查询有多少
     *
     * @param business
     * @return
     */
    int getBusTotal(Business business);

    /**
     * 查询有多少
     *
     * @param consumer
     * @return
     */
    int getConTotal(Consumer consumer);
}
