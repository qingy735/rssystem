package cn.edu.henu.test;

import cn.edu.henu.bean.Order;
import cn.edu.henu.bean.Order2;
import cn.edu.henu.bean.OrderDetail;
import cn.edu.henu.dao.OrderMapper2;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-11-27 17:21
 */
public class OrderTest2 {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private OrderMapper2 orderMapper2;

    @Before
    public void init() throws IOException {
        // 读取配置文件，生成字节输入流
        inputStream = Resources.getResourceAsStream("test/SqlMapConfig.xml");
        // 获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession对象
        sqlSession = factory.openSession();
        // 获取dao的代理对象
        orderMapper2 = sqlSession.getMapper(OrderMapper2.class);
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
        List<Order2> order2s = orderMapper2.selectByCid("1812030002");
        for (Order2 order2 : order2s) {
            System.out.println(order2);
        }
    }

    /**
     * 根据订单id修改订单状态
     */
    @Test
    public void testUpdateStatusByOid() {
        Order2 order2 = orderMapper2.selectByPrimaryKey(1);
        orderMapper2.updateStatusByOid(order2.getId(), 0);
    }

    /**
     * 根据商家id查询
     */
    @Test
    public void testFindAllByBid() {
        // 执行查询所有方法
        List<Order2> orders = orderMapper2.selectByBid(100001);
        for (Order2 order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void testInsert() {
        Order2 order = new Order2();
        order.setCid("1812030002");
        order.setBid(100001);
        order.setCode("gh84");
        order.setNote("测试插入");
        order.setStatus(0);
        orderMapper2.insert(order);
        int id = order.getId();
        for (int i = 0; i < 3; i++) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOid(id);
            orderDetail.setNum(i + 1);
            orderDetail.setDiscount((i + 1) * 5f);
            orderDetail.setPid(i + 1);
            orderMapper2.insertToDetail(orderDetail);
        }
    }
}
