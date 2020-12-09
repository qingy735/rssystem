package cn.edu.henu.service;

import cn.edu.henu.bean.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-12-03 14:32
 */
public interface IOrderService {

    /**
     * 根据id查询所有订单
     *
     * @param cid
     * @return
     */
    List<Order> selectByCid(String cid);

    /**
     * 根据商家id查询所有订单
     *
     * @param bid
     * @return
     */
    List<Order> selectByBid(Integer bid);

    /**
     * 根据订单id更改订单状态
     *
     * @param orderId
     * @param state
     * @return
     */
    int updateStatusByOid(Integer orderId, int state);

    /**
     * 根据pid批量更新状态
     *
     * @param pid
     * @param status
     * @return
     */
    int updateAllStatusByPid(Integer pid, int status);

    /**
     * 添加订单
     *
     * @param order
     * @return
     */
    int addOrder(Order order);
}
