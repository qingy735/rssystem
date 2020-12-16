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
     * 查询所有订单
     *
     * @return
     */
    List<Order> findAllOrder();

    /**
     * 查询所有评论
     *
     * @return
     */
    List<Comment> findAllComment();

    /**
     * 查询所有店铺信息
     *
     * @return
     */
    List<Business> findAllBusiness();

    /**
     * 查询所有消费者信息
     *
     * @return
     */
    List<Consumer> findAllConsumer();
}
