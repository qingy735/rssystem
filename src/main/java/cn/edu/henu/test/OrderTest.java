package cn.edu.henu.test;

import cn.edu.henu.bean.Order;
import cn.edu.henu.bean.Product;
import cn.edu.henu.dao.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-11-27 17:21
 */
public class OrderTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private OrderMapper orderMapper;

    @Before
    public void init() throws IOException {
        // 读取配置文件，生成字节输入流
        inputStream = Resources.getResourceAsStream("test/SqlMapConfig.xml");
        // 获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession对象
        sqlSession = factory.openSession();
        // 获取dao的代理对象
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @After
    public void destroy() throws IOException {
        // 提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
        inputStream.close();
    }

    /**
     * 测试查询用户所有
     */
    @Test
    public void testFindAllByCid() {
        // 执行查询所有方法
        List<Order> orders = orderMapper.selectByCid("1812030002");
        for (Order order : orders) {
            /*System.out.println(order.getCid());
            System.out.println(order.getPid());
            System.out.println(order.getBid());*/
            System.out.println("订单号：" + order.getOrderId());
            System.out.println("取餐码：" + order.getCode());
            System.out.println("商家名：" + order.getBusiness().getWname());
            System.out.println("商品名：" + order.getProduct().getProductName());
            System.out.println("单价：" + order.getProduct().getProductPrice());
            System.out.println("数量：" + order.getNum());
            System.out.println("总价：" + order.getTotalPrice());
            System.out.println("状态：" + order.getStatus());
            System.out.println("=========================");
            orderMapper.updateStatus(Integer.parseInt(order.getOrderId()), 1);
            System.out.println("状态：" + order.getStatus());
        }
    }

    /**
     * 根据商家id查询
     */
    @Test
    public void testFindAllByBid() {
        // 执行查询所有方法
        List<Order> orders = orderMapper.selectByBid(100001);
        for (Order order : orders) {
            System.out.println("订单号：" + order.getOrderId());
            System.out.println("消费者：" + order.getConsumer().getName());
            System.out.println("下单时间：" + order.getOrderTime());
            System.out.println("总价：" + order.getTotalPrice());
            System.out.println("状态：" + order.getStatus());
        }
    }
}
