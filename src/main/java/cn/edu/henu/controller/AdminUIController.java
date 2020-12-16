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
public class AdminUIController {

    @RequestMapping("/buAdmin")
    public String toBuAdmin() {
        return "/admin/buAdmin";
    }

    @RequestMapping("/conAdmin")
    public String toConAdmin() {
        return "/admin/conAdmin";
    }

    @RequestMapping("/commentAd")
    public String toCommentAd() {
        return "/admin/commentAd";
    }

    @RequestMapping("/orderAd")
    public String toOrderAd() {
        return "/admin/orderAd";
    }

    @RequestMapping("/home")
    public String toHome(HttpSession session) {
        Admin admLoginInfo = (Admin) session.getAttribute("admLoginInfo");
        if (admLoginInfo == null) {
            return "redirect:/login/admin";
        }
        return "/admin/adminhome";
    }

}
