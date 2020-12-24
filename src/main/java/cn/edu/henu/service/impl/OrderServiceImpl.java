package cn.edu.henu.service.impl;

import cn.edu.henu.bean.Order;
import cn.edu.henu.bean.OrderDetail;
import cn.edu.henu.dao.OrderMapper;
import cn.edu.henu.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-12-03 14:34
 */
@Service("orderSer")
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> selectByCid(String cid) {
        try {
            List<Order> orders = orderMapper.selectByCid(cid);
            for (Order order : orders) {
                Integer oid = order.getId();
                List<OrderDetail> details = orderMapper.selectByOid(oid);
                order.setDetails(details);
            }
            return orders;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Order> selectByBid(Integer bid) {
        try {
            List<Order> orders = orderMapper.selectByBid(bid);
            for (Order order : orders) {
                Integer oid = order.getId();
                List<OrderDetail> details = orderMapper.selectByOid(oid);
                order.setDetails(details);
            }
            return orders;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Order selectByPrimaryKey(Integer oid) {
        try {
            Order order = orderMapper.selectByPrimaryKey(oid);
            List<OrderDetail> details = orderMapper.selectByOid(oid);
            order.setDetails(details);
            return order;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<OrderDetail> selectByOid(Integer oid) {
        try {
            return orderMapper.selectByOid(oid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int updateByPrimaryKey(Order order) {
        try {
            String note = order.getNote();
            if (note == null) {
                order.setNote("无");
            } else {
                note = note.replaceAll(" ", "");
                order.setNote(note);
            }
            return orderMapper.updateByPrimaryKey(order);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addOrder(Order order, List<OrderDetail> details) {
        try {
            int insert = orderMapper.insert(order);
            if (insert < 1) {
                throw new Exception();
            }
            int oid = order.getId();
            for (OrderDetail detail : details) {
                detail.setOid(oid);
                orderMapper.insertToDetail(detail);
            }
            return insert;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
