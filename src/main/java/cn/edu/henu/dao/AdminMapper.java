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
     * 查询所有评论
     *
     * @return
     */
    List<Comment> selectAllComment();

    /**
     * 查询所有店铺信息
     *
     * @return
     */
    List<Business> selectAllBusiness();

    /**
     * 查询所有消费者信息
     *
     * @return
     */
    List<Consumer> selectAllConsumer();

}
