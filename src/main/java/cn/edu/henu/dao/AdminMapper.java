package cn.edu.henu.dao;

import cn.edu.henu.bean.Admin;

/**
 * @author Qing_Y
 * @date 2020-12-07 23:08
 */
public interface AdminMapper {

    /**
     * 根据用户名查找
     *
     * @param username
     * @return
     */
    Admin selectByPrimarykey(String username);
}
