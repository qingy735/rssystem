package cn.edu.henu.controller;

import cn.edu.henu.bean.Business;
import cn.edu.henu.bean.Consumer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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
    public String businessRegister(Model model, HttpSession session) {
        Integer registerCode = (Integer) session.getAttribute("tempId");
        // 不为空肯定小于0
        if (registerCode != null) {
            Business errBusiness = (Business) session.getAttribute("errorRegisterInfoOfBusiness");
            session.removeAttribute("errorRegisterInfoOfBusiness");
            model.addAttribute("errBusiness", errBusiness);
            if (registerCode == -1) {
                model.addAttribute("bus_register_msg", "插入数据失败");
            } else if (registerCode == -2) {
                model.addAttribute("bus_register_msg", "数据传递时丢失");
            } else if (registerCode == 0) {
                model.addAttribute("bus_register_msg", "该餐厅中的已经存在该窗口id");
            }
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
        Integer registerCode = (Integer) session.getAttribute("conRegisterCode");
        if (registerCode != null) {
            Consumer consumer = (Consumer) session.getAttribute("errorRegisterInfoOfConsumer");
            model.addAttribute("errConsumer", consumer);
            session.removeAttribute("errorRegisterInfoOfConsumer");
            if (registerCode == 0) {
                model.addAttribute("con_register_msg", "该用户名已经存在");
            } else if (registerCode == -1) {
                model.addAttribute("con_register_msg", "插入数据失败");
            } else if (registerCode == -2) {
                model.addAttribute("con_register_msg", "数据传递时丢失");
            }
        }
        return "login&register/StRegister";
    }

}
