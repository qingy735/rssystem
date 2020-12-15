package cn.edu.henu.test;

import cn.edu.henu.bean.Shop;
import cn.edu.henu.dao.ShopMapper;
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
 * @date 2020-12-13 17:39
 */
public class ShopTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private ShopMapper shopMapper;

    @Before
    public void init() throws IOException {
        // 读取配置文件，生成字节输入流
        inputStream = Resources.getResourceAsStream("test/SqlMapConfig.xml");
        // 获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession对象
        sqlSession = factory.openSession();
        // 获取dao的代理对象
        shopMapper = sqlSession.getMapper(ShopMapper.class);
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
    public void testSelectAll() {
        List<Shop> shops = shopMapper.selectAll();
        for (Shop shop : shops) {
            System.out.println(shop);
        }

    }

    @Test
    public void testInsert() {
        Shop shop = new Shop();
        shop.setCid("1812030001");
        shop.setBid(100001);
        shop.setPid(4);
        shop.setPnum(2);
        shop.setDiscountuse(5f);
        int insert = shopMapper.insert(shop);
        System.out.println(insert);
    }

    @Test
    public void testDelete() {
        int delete = shopMapper.deleteByPrimaryKey(3);
        System.out.println(delete);
    }

    @Test
    public void testUpdate() {
        Shop shop = new Shop();
        shop.setId(4);
        shop.setPnum(5);
        shop.setDiscountuse(40f);
        int update = shopMapper.updateByPrimaryKey(shop);
        System.out.println(update);
    }

}
