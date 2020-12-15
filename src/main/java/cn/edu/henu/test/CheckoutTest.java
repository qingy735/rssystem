package cn.edu.henu.test;


import cn.edu.henu.bean.Order;
import cn.edu.henu.bean.OrderDetail;
import cn.edu.henu.service.ICheckoutService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-12-15 19:33
 */
public class CheckoutTest {

    @Test
    public void testCheckout() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
        ICheckoutService checkoutSer = ac.getBean("checkoutSer", ICheckoutService.class);
        Order order = new Order();
        order.setCid("1812030001");
        order.setBid(100001);
        order.setCode("abcd");
        order.setNote("测试结账");
        order.setStatus(0);
        List<OrderDetail> details = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setNum(3);
        orderDetail.setDiscount(43f);
        orderDetail.setPid(5);
        details.add(orderDetail);
        orderDetail = new OrderDetail();
        orderDetail.setNum(3);
        orderDetail.setDiscount(20f);
        orderDetail.setPid(4);
        details.add(orderDetail);
        List<Integer> ids = new ArrayList<>();
        ids.add(5);
        ids.add(6);
        try {
            int checkout = checkoutSer.checkout(order, details, ids);
            System.out.println(checkout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
