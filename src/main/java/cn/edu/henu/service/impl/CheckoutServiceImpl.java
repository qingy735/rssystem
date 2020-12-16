package cn.edu.henu.service.impl;

import cn.edu.henu.bean.Order;
import cn.edu.henu.bean.OrderDetail;
import cn.edu.henu.dao.OrderMapper;
import cn.edu.henu.dao.ShopMapper;
import cn.edu.henu.service.ICheckoutService;
import cn.edu.henu.service.IOrderService;
import cn.edu.henu.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-12-15 19:10
 */
@Service("checkoutSer")
public class CheckoutServiceImpl implements ICheckoutService {

    @Autowired
    private IShopService shopSer;
    @Autowired
    private IOrderService orderSer;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int checkout(Order order, List<OrderDetail> details, List<Integer> ids) throws Exception {
        // 添加进订单
        int i = orderSer.addOrder(order, details);
        if (i < 1) {
            throw new Exception();
        }
        System.out.println("订单添加成功");
        int delete = shopSer.batchDelete(ids);
        if (delete < 1) {
            throw new Exception();
        }
        System.out.println("购物车删除成功");
        return delete;
    }
}
