package cn.edu.henu.service;

import cn.edu.henu.bean.Order;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-12-03 14:32
 */
public interface IOrderService {

    /**
     * 根据id查询所有订单
     *
     * @param id
     * @return
     */
    List<Order> selectByCid(String id);
}
