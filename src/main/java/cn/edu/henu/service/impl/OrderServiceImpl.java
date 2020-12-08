package cn.edu.henu.service.impl;

import cn.edu.henu.bean.Order;
import cn.edu.henu.dao.OrderMapper;
import cn.edu.henu.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Order> selectByCid(String id) {
        try {
            return orderMapper.selectByCid(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Order> selectByBid(Integer bid) {
        try {
            return orderMapper.selectByBid(bid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int updateAllStatusByPid(Integer pid, int status) {
        try {
            return orderMapper.updateAllStatusByPid(pid, status);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
