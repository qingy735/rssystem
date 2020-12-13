package cn.edu.henu.dao;

import cn.edu.henu.bean.Order;
import cn.edu.henu.bean.Order2;
import cn.edu.henu.bean.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-11-27 17:01
 */
public interface OrderMapper2 extends CrudDao<Order2> {
    /**
     * 查询对应id消费者的所有订单
     *
     * @param cid
     * @return
     */
    List<Order2> selectByCid(String cid);

    /**
     * 查询对应id商家的所有订单
     *
     * @param bid
     * @return
     */
    List<Order2> selectByBid(Integer bid);

    /**
     * 根据订单id更改订单状态
     *
     * @param orderId
     * @param state
     * @return
     */
    int updateStatusByOid(@Param("id") Integer orderId, @Param("status") Integer state);

    /**
     * 插入订单详情项
     *
     * @param orderDetail
     * @return
     */
    int insertToDetail(OrderDetail orderDetail);

}
