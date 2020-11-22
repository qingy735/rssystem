package cn.edu.henu.controller;

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

    @RequestMapping("/register")
    public String businessRegister(Business business, HttpSession session) {
        System.out.println(business);
        Integer id = businessSer.save(business);
        if (id != -1) {
            System.out.println("注册完成...");
            session.setAttribute("tempId", id);
        } else {
            System.out.println("注册失败...");
        }
        return "redirect:/login/business";
    }

    @RequestMapping("/home")
    public String toBusinessHome() {
        System.out.println("跳转到商家主页...");
        return "success";
    }

}
