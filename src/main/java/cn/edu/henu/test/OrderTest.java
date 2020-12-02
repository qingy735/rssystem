package cn.edu.henu.test;

import cn.edu.henu.bean.Order;
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
     * 测试查询所有
     */
    @Test
    public void testFindAll() {
        // 执行查询所有方法
        List<Order> orders = orderMapper.selectByCid("1812030001");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
