package cn.edu.henu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.henu.bean.Business;
import cn.edu.henu.dao.IBusinessDao;

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
    public boolean add(Business business) {
        if (business == null) {
            return false;
        }
        String sql = "insert into businessinfo(username,password,name,rid,wid,tel,grade) values(?,?,?,?,?,?,'-1')";
        jdbcTemplate.update(sql,
                business.getUsername(),
                business.getPassword(),
                business.getName(),
                business.getRid(),
                business.getWid(),
                business.getTel());
        return true;
    }

}
