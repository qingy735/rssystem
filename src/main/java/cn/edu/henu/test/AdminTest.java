package cn.edu.henu.test;

import cn.edu.henu.bean.*;
import cn.edu.henu.dao.AdminMapper;
import cn.edu.henu.dao.OrderMapper;
import cn.edu.henu.dao.ProductMapper;
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
 * @date 2020-12-07 23:13
 */
public class AdminTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private AdminMapper adminMapper;
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
        adminMapper = sqlSession.getMapper(AdminMapper.class);
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

    @Test
    public void testSelectOne() {
        Admin admin = adminMapper.selectByPrimarykey("admin");
        System.out.println(admin);
    }

    @Test
    public void testFindConsumer() {
        List<Consumer> consumers = adminMapper.selectAllConsumer();
        for (Consumer consumer : consumers) {
            System.out.println(consumer);
        }
    }

    @Test
    public void testFindBusiness() {
        List<Business> businesses = adminMapper.selectAllBusiness();
        for (Business business : businesses) {
            System.out.println(business);
        }
    }

    @Test
    public void testFindOrder() {
        List<Order> orders = adminMapper.selectAllOrder();
        for (Order order : orders) {
            Integer id = order.getId();
            List<OrderDetail> details = orderMapper.selectByOid(id);
            order.setDetails(details);
            System.out.println(order);
        }
    }

}
