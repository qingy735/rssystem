package cn.edu.henu.test;

import cn.edu.henu.bean.Condition;
import cn.edu.henu.bean.Product;
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
 * @date 2020-12-03 15:06
 */
public class ProductTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private ProductMapper productMapper;

    @Before
    public void init() throws IOException {
        // 读取配置文件，生成字节输入流
        inputStream = Resources.getResourceAsStream("test/SqlMapConfig.xml");
        // 获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession对象
        sqlSession = factory.openSession();
        // 获取dao的代理对象
        productMapper = sqlSession.getMapper(ProductMapper.class);
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
     * 测试条件查询
     */
    @Test
    public void testFindSome() {
        Condition condition = new Condition();
        condition.setName("生菜");
        List<Product> products = productMapper.selectByCondition(condition);
        for (Product pro : products) {
            System.out.println(pro.getBusiness().getUsername());
        }
    }

    @Test
    public void testGetAll() {
        List<Product> products = productMapper.selectAll();
        for (Product product : products) {
            System.out.println(product.getBusiness().getUsername());
            System.out.println("===================");
        }
    }

    @Test
    public void testGetAllByBid() {
        List<Product> products = productMapper.getAllByBid(100001);
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    public void testSelectSimple() {
        List<Product> products = productMapper.selectSimple();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    public void testInsert() {
        Product product = new Product();
        product.setProductName("啊啊啊");
        product.setProductPrice(3f);
        product.setPhotosrc("images/aaa.jpg");
        product.setProductIntr("啊啊啊");
        productMapper.insert(product, 100001);
        System.out.println(product);
    }

    /**
     * 查询条目
     */
    @Test
    public void testFindTotal() {
        int i = productMapper.selectTotal(new Condition());
        System.out.println(i);
    }
}
