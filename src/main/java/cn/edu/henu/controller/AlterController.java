package cn.edu.henu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 修改消费者或者商家信息
 *
 * @author Qing_Y
 * @date 2020-11-26 15:02
 */
@Controller
@RequestMapping("/alterInfo")
public class AlterController {

    @RequestMapping("/alterNickname")
    public String toAlterNickname(HttpSession session, Model model) {
        String updateNickInfo = (String) session.getAttribute("updateInfo");
        if (updateNickInfo != null) {
            model.addAttribute("updateInfo", updateNickInfo);
            session.removeAttribute("updateInfo");
        }
        return "consumer/alterInfo/alterNickname";
    }

    @RequestMapping("/alterPassword")
    public String toAlterPassword(HttpSession session, Model model) {
        String updatePassInfo = (String) session.getAttribute("updateInfo");
        if (updatePassInfo != null) {
            model.addAttribute("updateInfo", updatePassInfo);
            session.removeAttribute("updateInfo");
        }
        return "consumer/alterInfo/alterPassword";
    }

}
