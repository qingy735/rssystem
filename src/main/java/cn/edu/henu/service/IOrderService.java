package cn.edu.henu.service;

import cn.edu.henu.bean.Order;
import cn.edu.henu.bean.OrderDetail;
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
     * 根据订单id查找
     *
     * @param id
     * @return
     */
    Order selectByPrimaryKey(Integer id);

    /**
     * 根据订单id查找详细订单
     *
     * @param oid
     * @return
     */
    List<OrderDetail> selectByOid(Integer oid);

    /**
     * 根据订单id更改订单xinxi
     *
     * @param order
     * @return
     */
    int updateByPrimaryKey(Order order);

    /**
     * 添加订单
     *
     * @param order
     * @param details
     * @return
     */
    int addOrder(Order order, List<OrderDetail> details);
}
