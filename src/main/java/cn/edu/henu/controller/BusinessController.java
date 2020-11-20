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

    @RequestMapping("/login")
    public String toLoginPage() {
        System.out.println("跳转到登录页面...");
        return "login&register/BuLogin";
    }

    @RequestMapping("/logincheck")
    public String businessLogin(Business business) {

        Boolean login = businessSer.login(business);
        System.out.println("登录校验完成..." + login);

        return "success";
    }

}
