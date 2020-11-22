package cn.edu.henu.controller;

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
        if (verifyCode == null || verifyCode.length() < CHECK_CODE_LEN) {
            model.addAttribute("con_login_msg", "验证码错误");
            return "login&register/StLogin";
        } else {
            String checkCode = (String) session.getAttribute("checkCode");
            if (verifyCode.equalsIgnoreCase(checkCode)) {
                System.out.println(username + "---" + password);
                Consumer loginCon = consumerSer.login(username, password);
                System.out.println("登录校验完成..." + loginCon);
                if (loginCon != null) {
                    session.setAttribute("conLoginInfo", loginCon);
                    System.out.println("查询成功...");
                    return "redirect:/consumer/home";
                }
                model.addAttribute("con_login_msg", "账号或密码错误");
                return "login&register/StLogin";
            } else {
                model.addAttribute("con_login_msg", "验证码错误");
                return "login&register/StLogin";
            }
        }
    }

    @RequestMapping("/register")
    public String businessRegister(Consumer consumer) {
        System.out.println(consumer);
        boolean flag = consumerSer.save(consumer);
        if (flag) {
            System.out.println("注册完成...");
        } else {
            System.out.println("注册失败...");
        }
        return "redirect:/login/consumer";
    }

    @RequestMapping("/home")
    public String toBusinessHome() {
        System.out.println("跳转到商家主页...");
        return "success";
    }
}
