package cn.edu.henu.service;

import cn.edu.henu.bean.Order;
import cn.edu.henu.bean.OrderDetail;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-12-15 19:10
 */
public interface ICheckoutService {
    /**
     * 给商品结账
     * 从购物车中加入订单
     * 从购物车删除
     *
     * @param order   总订单
     * @param details 订单详情
     * @param ids     购物车子项id
     * @return
     */
    int checkout(Order order, List<OrderDetail> details, List<Integer> ids) throws Exception;
}
