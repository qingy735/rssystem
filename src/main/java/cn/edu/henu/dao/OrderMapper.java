package cn.edu.henu.dao;

import cn.edu.henu.bean.Order;
import cn.edu.henu.bean.OrderDetail;
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
     * 查询对应oid的所有订单详情
     *
     * @param oid
     * @return
     */
    List<OrderDetail> selectByOid(Integer oid);

    /**
     * 查询对应id商家的所有订单
     *
     * @param bid
     * @return
     */
    List<Order> selectByBid(Integer bid);

    /**
     * 插入订单详情项
     *
     * @param orderDetail
     * @return
     */
    int insertToDetail(OrderDetail orderDetail);

}
