package cn.edu.henu.intercept;

import cn.edu.henu.bean.Restaurant;
import cn.edu.henu.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Qing_Y
 */
public class RegisterIntercept implements HandlerInterceptor {

    @Autowired
    private IRestaurantService restaurantSer;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if (uri.contains("business")) {
            System.out.println("正在查询餐厅名称...");
            List<Restaurant> restaurants = restaurantSer.getAllRestaurant();
            request.setAttribute("restaurants", restaurants);
        }
        return true;
    }
}
