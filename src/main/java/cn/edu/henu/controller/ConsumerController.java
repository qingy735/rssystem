package cn.edu.henu.controller;

import cn.edu.henu.bean.Business;
import cn.edu.henu.bean.Consumer;
import cn.edu.henu.service.IConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 异步登录校验
     * Map集合    存放的登录验证和登录提示
     * flag：-1失败   1：成功
     * bus_login_msg:显示错误登录信息
     *
     * @param body    存放请求体信息：username、password、verifyCode
     * @param session 用来获取验证码
     * @return map集合
     */
    @ResponseBody
    @RequestMapping("/login")
    public Map<String, Object> businessLoginAjax(@RequestBody String body, HttpSession session) {
        Map<String, Object> info = new HashMap<>();
        body = body.replace("\"", "");
        String[] params = body.split("&");
        String username = params[0].split("=")[1];
        String password = params[1].split("=")[1];
        String verifyCode = params[2].split("=")[1];

        if (verifyCode == null || verifyCode.length() < CHECK_CODE_LEN) {
            info.put("con_login_msg", "验证码错误");
            info.put("flag", -1);
        } else {
            String checkCode = (String) session.getAttribute("checkCode");
            if (verifyCode.equalsIgnoreCase(checkCode)) {
                // 销毁验证码防止重复提交请求
                session.removeAttribute("checkCode");
                Consumer loginCon = consumerSer.login(username, password);
                System.out.println("登录校验完成..." + loginCon);
                if (loginCon != null) {
                    session.setAttribute("conLoginInfo", loginCon);
                    System.out.println("查询成功...");
                    info.put("con_login_msg", "成功");
                    info.put("flag", 1);
                    return info;
                }
                info.put("con_login_msg", "账号或密码错误");
                info.put("flag", -1);
            } else {
                info.put("con_login_msg", "验证码错误");
                System.out.println("验证码错误");
                info.put("flag", -1);
            }
        }
        return info;
    }

    // @RequestMapping("/login")
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
     * @param bindingResult
     * @param session
     * @return
     */
    @RequestMapping("/register")
    public String businessRegister(@Validated Consumer consumer, BindingResult bindingResult, HttpSession session) {
        // 表单校验
        Map<String, Object> errorsMap = new HashMap<String, Object>();
        boolean hasErrors = bindingResult.hasErrors();
        if (hasErrors) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors) {
                errorsMap.put(error.getField(), error.getDefaultMessage());
            }
            session.setAttribute("errorInfo", errorsMap);
            System.out.println("有检验错误...");
            // 存放注册错误对象
            session.setAttribute("errConsumer", consumer);
            return "redirect:/register/consumer";
        }

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
