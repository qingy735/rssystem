package cn.edu.henu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.henu.bean.Business;
import cn.edu.henu.dao.IBusinessDao;
import cn.edu.henu.service.IBusinessService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Qing_Y
 */
@Service("businessSer")
public class BusinessServiceImpl implements IBusinessService {

    @Autowired
    private IBusinessDao businessDao;

    @Override
    public List<Business> getAllBusiness() {
        return businessDao.getAllBusiness();
    }

    @Override
    public Boolean login(Business business) {
        Integer id = business.getId();
        System.out.println("业务层登录校验...");
        if (businessDao.getOneById(id) != null) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteById(Integer id) {
        businessDao.deleteById(id);
    }

    @Override
    public void update(Business business) {
        businessDao.update(business);
    }

    @Override
    public void add(Business business) {
        // TODO Auto-generated method stub

    }
}
