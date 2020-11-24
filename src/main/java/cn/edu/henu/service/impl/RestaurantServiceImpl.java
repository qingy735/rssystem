package cn.edu.henu.service.impl;

import cn.edu.henu.bean.Restaurant;
import cn.edu.henu.dao.RestaurantMapper;
import cn.edu.henu.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Qing_Y
 */
@Service("restaurantSer")
public class RestaurantServiceImpl implements IRestaurantService {

    @Autowired
    private RestaurantMapper restaurantDao;

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantDao.selectAll();
    }
}
