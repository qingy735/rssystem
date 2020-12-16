package cn.edu.henu.controller;

import cn.edu.henu.bean.Admin;
import cn.edu.henu.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Qing_Y
 * @date 2020-12-07 23:22
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminSer;

    @ResponseBody
    @RequestMapping("/login")
    public Map<String, Object> login(@RequestBody String body, HttpSession session) {
        Map<String, Object> info = new HashMap<>();
        body = body.replace("\"", "");
        System.out.println(body);
        System.out.println(body);
        String[] params = body.split("&");
        String username = params[0].split("=")[1];
        String password = params[1].split("=")[1];
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        Boolean login = adminSer.login(admin);
        if (login) {
            info.put("login_msg", "成功");
            info.put("flag", 1);
            System.out.println(admin);
            session.setAttribute("admLoginInfo", admin);
        } else {
            info.put("login_msg", "账号或密码错误");
            info.put("flag", -1);
        }
        return info;
    }

    @RequestMapping("/orders")
    public String findAllOrder() {
        adminSer.findAllOrder();
        return "success";
    }

    @RequestMapping("/comments")
    public String findAllComment() {
        adminSer.findAllComment();
        return "success";
    }

    @RequestMapping("/businesses")
    public String findAllBusiness() {
        adminSer.findAllBusiness();
        return "success";
    }

    @RequestMapping("/consumers")
    public String findAllConsumer() {
        adminSer.findAllConsumer();
        return "success";
    }

}
