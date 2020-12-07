package cn.edu.henu.test;

import cn.edu.henu.bean.Admin;
import cn.edu.henu.dao.AdminMapper;
import cn.edu.henu.dao.ProductMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Qing_Y
 * @date 2020-12-07 23:13
 */
public class AdminTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private AdminMapper adminMapper;

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

}
