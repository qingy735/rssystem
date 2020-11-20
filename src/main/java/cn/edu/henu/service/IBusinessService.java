package cn.edu.henu.service;

import java.util.List;

import cn.edu.henu.bean.Business;
import org.springframework.stereotype.Service;

/**
 * @author Qing_Y
 */
public interface IBusinessService {

    /**
     * 登录验证
     * @param username
     * @param password
     * @return
     */
    Boolean login(String username, String password);

    /**
     * 根据商家id删除商家
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 修改商家信息
     *
     * @param business
     */
    void update(Business business);

    /**
     * 添加商家
     *
     * @param business
     */
    void save(Business business);
}
