package cn.edu.henu.dao;

import cn.edu.henu.bean.Order;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 更改订单状态
     *
     * @param orderId
     * @param state
     * @return
     */
    int updateStatus(@Param("id") Integer orderId, @Param("status") Integer state);

}
