package cn.edu.henu.dao.impl;

import java.util.List;

import cn.edu.henu.bean.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.henu.dao.IConsumerDao;

/**
 * @author Qing_Y
 */
@Repository("consumerDao")
public class ConsumerDaoImpl implements IConsumerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Consumer> getAllCustomer() {

        return null;
    }

    @Override
    public Consumer getOneByUsername(String username) {
        final String sql = "select * from consumerinfo where username = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Consumer.class), username);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void update(Consumer consumer) {

    }

    /**
     * 添加用户
     *
     * @param consumer
     * @return
     */
    @Override
    public Integer add(Consumer consumer) {
        if (consumer == null) {
            return -2;
        }

        Consumer oneByUsername = getOneByUsername(consumer.getUsername());
        // 数据库中不存在这个用户id即username
        if (oneByUsername == null) {
            final String sql = "insert into consumerinfo(username,password,name,nickname,sex,tel) values(?,?,?,?,?,?)";
            String nickname = consumer.getNickname() == null ? consumer.getUsername() : consumer.getNickname();
            try {
                jdbcTemplate.update(sql, consumer.getUsername(), consumer.getPassword(), consumer.getName(), nickname, consumer.getSex(), consumer.getTel());
                return 1;
            } catch (DataAccessException e) {
                return -1;
            }
        }
        return 0;
    }

    /**
     * 根据用户名和密码进行登录校验
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public Consumer getOneByLoginInfo(String username, String password) {
        Consumer consumer = getOneByUsername(username);
        if (consumer != null && consumer.getPassword().equals(password)) {
            return consumer;
        }
        return null;
    }

}
