package cn.edu.henu.controller;

import cn.edu.henu.bean.Business;
import cn.edu.henu.bean.Consumer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Qing_Y
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    /**
     * 跳转到商家注册页面
     * 用于商家注册校验
     * 校验码：
     * >0：成功
     * 0：数据库中已经存在这个餐厅下的该窗口号
     * -1：插入数据失败
     * -2：传入数据为null
     *
     * @return
     */
    @RequestMapping("/business")
    public String businessRegister(Model model, HttpSession session) {
        Map<String, Object> errorInfo = (Map<String, Object>) session.getAttribute("errorInfo");
        session.removeAttribute("errorInfo");
        if (errorInfo != null && !errorInfo.isEmpty()) {
            model.addAttribute("errorInfo", errorInfo);
            Business errBusiness = (Business) session.getAttribute("errBusiness");
            model.addAttribute("errBusiness", errBusiness);
            session.removeAttribute("errBusiness");
            return "login&register/BuRegister";
        }

        Integer busRegisterCode = (Integer) session.getAttribute("busRegisterCode");
        // 清除商家注册校验码，防止刷新后进入方法放入一个为null的Business对象
        session.removeAttribute("busRegisterCode");
        if (busRegisterCode != null && busRegisterCode <= 0) {
            session.removeAttribute("buRegisterCode");
            if (busRegisterCode == -1) {
                model.addAttribute("bus_register_msg", "插入数据失败");
            } else if (busRegisterCode == -2) {
                model.addAttribute("bus_register_msg", "数据传递时丢失");
            } else if (busRegisterCode == 0) {
                model.addAttribute("bus_register_msg", "该餐厅中的已经存在该窗口id");
            }
            Business errBusiness = (Business) session.getAttribute("errBusiness");
            model.addAttribute("errBusiness", errBusiness);
            session.removeAttribute("errBusiness");
        } else {
            model.addAttribute("errBusiness", new Business());
        }
        return "login&register/BuRegister";
    }

    /**
     * 跳转到顾客注册页面
     *
     * @return
     */
    @RequestMapping("/consumer")
    public String customerRegister(Model model, HttpSession session) {
        Map<String, Object> errorInfo = (Map<String, Object>) session.getAttribute("errorInfo");
        session.removeAttribute("errorInfo");
        if (errorInfo != null && !errorInfo.isEmpty()) {
            model.addAttribute("errorInfo", errorInfo);
            Consumer errConsumer = (Consumer) session.getAttribute("errConsumer");
            model.addAttribute("errConsumer", errConsumer);
            session.removeAttribute("errConsumer");
            return "login&register/StRegister";
        }

        Integer conRegisterCode = (Integer) session.getAttribute("conRegisterCode");
        session.removeAttribute("conRegisterCode");
        if (conRegisterCode != null && conRegisterCode <= 0) {
            if (conRegisterCode == 0) {
                model.addAttribute("con_register_msg", "该用户名已经存在");
            } else if (conRegisterCode == -1) {
                model.addAttribute("con_register_msg", "插入数据失败");
            } else if (conRegisterCode == -2) {
                model.addAttribute("con_register_msg", "数据传递时丢失");
            }
            Consumer errConsumer = (Consumer) session.getAttribute("errConsumer");
            model.addAttribute("errConsumer", errConsumer);
            session.removeAttribute("errConsumer");
        } else {
            model.addAttribute("errConsumer", new Consumer());
        }
        return "login&register/StRegister";
    }

}
