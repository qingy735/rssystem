package cn.edu.henu.controller;

import cn.edu.henu.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.henu.bean.Business;
import cn.edu.henu.service.IBusinessService;

import javax.servlet.http.HttpSession;

/**
 * @author Qing_Y
 */
@Controller
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private IBusinessService businessSer;
    @Autowired
    private IRestaurantService restaurantSer;
    final Integer CHECK_CODE_LEN = 4;

    /**
     * 登录校验
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public String businessLogin(String username, String password, String verifyCode, HttpSession session, Model model) {
        if (verifyCode == null || verifyCode.length() < CHECK_CODE_LEN) {
            model.addAttribute("bus_login_msg", "验证码错误");
            return "login&register/BuLogin";
        } else {
            String checkCode = (String) session.getAttribute("checkCode");
            if (verifyCode.equalsIgnoreCase(checkCode)) {
                Business loginBus = businessSer.login(username, password);
                System.out.println("登录校验完成..." + loginBus);
                if (loginBus != null) {
                    session.setAttribute("busLoginInfo", loginBus);
                    System.out.println("查询成功...");
                    return "redirect:/business/home";
                }
                model.addAttribute("bus_login_msg", "账号或密码错误");
                return "login&register/BuLogin";
            } else {
                model.addAttribute("bus_login_msg", "验证码错误");
                return "login&register/BuLogin";
            }
        }
    }

    /**
     * 用于商家注册校验
     * 校验码：
     * >0：成功
     * 0：数据库中已经存在这个餐厅下的该窗口号
     * -1：插入数据失败
     * -2：传入数据为null
     *
     * @param business
     * @param session
     * @return
     */
    @RequestMapping("/register")
    public String businessRegister(Business business, HttpSession session) {
        Integer id = businessSer.save(business);
        // 注册成功 跳转到登陆界面
        if (id > 0) {
            System.out.println("注册完成...");
            // 存放商家注册成功后生成的id
            session.setAttribute("busId", id);
            return "redirect:/login/business";
        } else { // 注册失败    跳转到注册界面
            System.out.println("注册失败...");
            // 存放注册校验码
            session.setAttribute("busRegisterCode", id);
            // 存放注册错误对象
            session.setAttribute("errBusiness", business);
            return "redirect:/register/business";
        }
    }


    @RequestMapping("/home")
    public String toBusinessHome() {
        System.out.println("跳转到商家主页...");
        return "success";
    }

}