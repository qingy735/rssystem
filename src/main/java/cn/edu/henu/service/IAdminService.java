package cn.edu.henu.service;

import cn.edu.henu.bean.Admin;

/**
 * @author Qing_Y
 * @date 2020-12-07 23:18
 */
public interface IAdminService {
    /**
     * 登录功能
     *
     * @param admin
     * @return
     */
    Boolean login(Admin admin);
}
