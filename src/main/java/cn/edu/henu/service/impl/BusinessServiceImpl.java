package cn.edu.henu.service.impl;

import cn.edu.henu.dao.BusinessMapper;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.henu.bean.Business;
import cn.edu.henu.service.IBusinessService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Qing_Y
 */
@Service("businessSer")
public class BusinessServiceImpl implements IBusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public Business login(String username, String password) {
        System.out.println("业务层登录校验...");
        try {
            Business business = businessMapper.selectByPrimaryKey(Integer.parseInt(username));
            if (business != null && password.equals(business.getPassword())) {
                return business;
            }
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        try {
            int i = businessMapper.deleteByPrimaryKey(id);
            return i >= 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Business business) {
        try {
            int i = businessMapper.updateByPrimaryKey(business);
            return i >= 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Integer save(Business business) {
        if (business == null) {
            return -2;
        }
        Business tempBusiness = new Business();
        tempBusiness.setRid(business.getRid());
        tempBusiness.setWid(business.getWid());
        List<Business> businesses = businessMapper.selectByCondition(tempBusiness);

        if (businesses == null || businesses.size() <= 0) {
            try {
                return businessMapper.insert(business);
            } catch (Exception e) {
                return -1;
            }
        }
        return 0;
    }
}
