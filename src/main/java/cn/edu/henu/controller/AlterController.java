package cn.edu.henu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String toAlterNickname() {
        System.out.println("我进来了...toAlterNickname");
        return "consumer/alterInfo/alterNickname";
    }

    @RequestMapping("/alterPassword")
    public String toAlterPassword() {
        System.out.println("我进来了...toAlterPassword");
        return "consumer/alterInfo/alterPassword";
    }

}
