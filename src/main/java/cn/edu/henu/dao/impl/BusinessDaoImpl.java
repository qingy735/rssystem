package cn.edu.henu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.henu.bean.Business;
import cn.edu.henu.dao.IBusinessDao;

/**
 * @author Qing_Y
 */
@Repository("businessDao")
public class BusinessDaoImpl implements IBusinessDao {

    @Override
    public List<Business> getAllBusiness() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Business getOneById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Business business) {
        // TODO Auto-generated method stub

    }

    @Override
    public void add(Business business) {
        // TODO Auto-generated method stub

    }

}
