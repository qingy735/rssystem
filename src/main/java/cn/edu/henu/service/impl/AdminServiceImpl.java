package cn.edu.henu.service.impl;

import cn.edu.henu.bean.Admin;
import cn.edu.henu.dao.AdminMapper;
import cn.edu.henu.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Qing_Y
 * @date 2020-12-07 23:19
 */
@Service("adminSer")
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Boolean login(Admin admin) {
        String username = admin.getUsername();
        String password = admin.getPassword();
        Admin realAdmin = adminMapper.selectByPrimarykey(username);
        if (realAdmin != null) {
            return realAdmin.getPassword().equals(password);
        } else {
            return false;
        }
    }
}
