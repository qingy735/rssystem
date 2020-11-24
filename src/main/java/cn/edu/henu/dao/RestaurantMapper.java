package cn.edu.henu.dao;

import cn.edu.henu.bean.Restaurant;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-11-24 21:14
 */
public interface RestaurantMapper extends CrudDao<Restaurant> {
    /**
     * 查询所有数据
     *
     * @return
     */
    List<Restaurant> selectAll();
}
