package cn.edu.henu.dao;

import cn.edu.henu.bean.Restaurant;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Qing_Y
 */
public interface IRestaurantDao {

    /**
     * 查询所有餐厅信息方法
     *
     * @return
     */
    @Select("select * from restaurantinfo")
    List<Restaurant> selectAll();

}
