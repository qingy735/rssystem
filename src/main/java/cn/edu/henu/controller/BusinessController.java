package cn.edu.henu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.henu.bean.Business;
import cn.edu.henu.service.IBusinessService;

/**
 * @author Qing_Y
 */
@Controller
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private IBusinessService businessSer;

    /**
     * 登录校验
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public String businessLogin(String username, String password) {

        System.out.println(username + "--->" + password);
        Boolean login = businessSer.login(username, password);
        System.out.println("登录校验完成..." + login);

        return "redirect:/business/home";
    }

    @RequestMapping("/register")
    public String businessRegister(Business business) {
        businessSer.save(business);
        System.out.println("注册完成...");
        return "redirect:/login/business";
    }

    @RequestMapping("/home")
    public String toBusinessHome() {
        System.out.println("跳转到商家主页...");
        return "success";
    }

}
