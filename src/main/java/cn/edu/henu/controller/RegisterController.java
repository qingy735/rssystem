package cn.edu.henu.controller;

import cn.edu.henu.bean.Restaurant;
import cn.edu.henu.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Qing_Y
 */
@Controller
@RequestMapping("register")
public class RegisterController {

    /**
     * 跳转到商家注册页面
     *
     * @return
     */
    @RequestMapping("/business")
    public String businessRegister() {
        System.out.println("跳转到商家注册页面...");
        return "login&register/BuRegister";
    }

    /**
     * 跳转到顾客注册页面
     *
     * @return
     */
    @RequestMapping("/customer")
    public String customerRegister() {
        System.out.println("跳转到顾客注册页面...");
        return "login&register/StRegister";
    }

}
