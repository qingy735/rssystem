package cn.edu.henu.service;

import cn.edu.henu.bean.Restaurant;

import java.util.List;

/**
 * @author Qing_Y
 */
public interface IRestaurantService {

    /**
     * 查询所有餐厅信息
     *
     * @return
     */
    List<Restaurant> getAllRestaurant();

}
