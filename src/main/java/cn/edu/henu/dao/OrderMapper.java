package cn.edu.henu.dao;

import cn.edu.henu.bean.Order;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-11-27 17:01
 */
public interface OrderMapper extends CrudDao<Order> {
    /**
     * 查询对应id消费者的所有订单
     *
     * @param cid
     * @return
     */
    List<Order> selectByCid(String cid);
}
