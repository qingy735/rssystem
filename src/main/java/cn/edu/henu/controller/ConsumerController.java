package cn.edu.henu.controller;

import cn.edu.henu.bean.Business;
import cn.edu.henu.bean.Consumer;
import cn.edu.henu.service.IConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Qing_Y
 * @date 2020-11-22 18:38
 */
@Controller
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private IConsumerService consumerSer;
    final Integer CHECK_CODE_LEN = 4;

    @RequestMapping("/login")
    public String businessLogin(String username, String password, String verifyCode, HttpSession session, Model model) {
        /*if (verifyCode == null || verifyCode.length() < CHECK_CODE_LEN) {
            model.addAttribute("login_msg", "验证码错误");
            return "login&register/BuLogin";
        } else {
            String checkCode = (String) session.getAttribute("checkCode");
            if (verifyCode.equalsIgnoreCase(checkCode)) {
                Business loginBus = consumerSer.login(username, password);
                System.out.println("登录校验完成..." + loginBus);
                if (loginBus != null) {
                    session.setAttribute("busLoginInfo", loginBus);
                    System.out.println("查询成功...");
                    return "redirect:/business/home";
                }
                model.addAttribute("login_msg", "账号或密码错误");
                return "login&register/BuLogin";
            } else {
                model.addAttribute("login_msg", "验证码错误");
                return "login&register/BuLogin";
            }
        }*/
        System.out.println("username-->" + username + "\npassword--->" + password);
        return "login&register/StLogin";
    }

    @RequestMapping("/register")
    public String businessRegister(Consumer consumer, HttpSession session) {
        System.out.println(consumer);
        /*Integer id = consumerSer.save(business);
        System.out.println("注册完成...");
        session.setAttribute("tempId", id);*/
        return "redirect:/login/consumer";
    }

    @RequestMapping("/home")
    public String toBusinessHome() {
        System.out.println("跳转到商家主页...");
        return "success";
    }
}
