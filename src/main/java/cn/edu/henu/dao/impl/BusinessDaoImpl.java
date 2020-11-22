package cn.edu.henu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import cn.edu.henu.bean.Business;
import cn.edu.henu.dao.IBusinessDao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Objects;

/**
 * @author Qing_Y
 */
@Repository("businessDao")
public class BusinessDaoImpl implements IBusinessDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Business getOneByUsername(String username) {
        String sql = "select * from businessinfo where username = ?";
        System.out.println("持久层开始查询...");
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Business.class), username);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Business getOneByLoginInfo(String username, String password) {
        Business business = getOneByUsername(username);
        System.out.println(business);
        if (business != null && business.getPassword().equals(password)) {
            return business;
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
    }

    @Override
    public void update(Business business) {

    }

    /**
     * 添加商家信息，grade默认为-1
     *
     * @param business
     * @return
     */
    @Override
    public Integer add(Business business) {
        if (business == null) {
            return -1;
        }
        final String sql = "insert into businessinfo(password,name,rid,wid,wname,tel,grade) values(?,?,?,?,?,?,'-1')";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int i = 0;
            ps.setString(++i, business.getPassword());
            ps.setString(++i, business.getName());
            ps.setString(++i, business.getRid());
            ps.setInt(++i, business.getWid());
            ps.setString(++i, business.getWname());
            ps.setString(++i, business.getTel());
            return ps;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }

}
