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

    /**
     * 注册成功
     */
    final Integer REGISTER_SUCCESS = 1;

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

    /**
     * 注册校验码：
     * 1：成功
     * 0：username重复
     * -1：插入数据失败
     * -2：消费者信息转存丢失变为null
     *
     * @param consumer
     * @param session
     * @return
     */
    @RequestMapping("/register")
    public String businessRegister(Consumer consumer, HttpSession session) {
        System.out.println(consumer);
        Integer registerCode = consumerSer.save(consumer);
        if (REGISTER_SUCCESS.equals(registerCode)) {
            System.out.println("注册完成...");
            // 跳转到消费者登陆界面
            return "redirect:/login/consumer";
        } else {
            System.out.println("注册失败...");
            // 存入注册失败校验码
            session.setAttribute("conRegisterCode", registerCode);
            // 存入注册错误的消费者对象
            session.setAttribute("errConsumer", consumer);
            return "redirect:/register/consumer";
        }
    }

    @RequestMapping("/home")
    public String toBusinessHome() {
        System.out.println("跳转到商家主页...");
        return "success";
    }
}
