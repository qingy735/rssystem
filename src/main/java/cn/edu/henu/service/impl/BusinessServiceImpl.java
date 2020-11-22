package cn.edu.henu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.henu.bean.Business;
import cn.edu.henu.dao.IBusinessDao;
import cn.edu.henu.service.IBusinessService;
import org.springframework.stereotype.Service;

/**
 * @author Qing_Y
 */
@Service("businessSer")
public class BusinessServiceImpl implements IBusinessService {

    @Autowired
    private IBusinessDao businessDao;

    @Override
    public Business login(String username, String password) {
        System.out.println("业务层登录校验...");
        return businessDao.getOneByLoginInfo(username, password);
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
    public Integer save(Business business) {
        return businessDao.add(business);
    }
}
