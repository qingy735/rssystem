package cn.edu.henu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Qing_Y
 */
@Controller
public class ActionController {

    @RequestMapping("/first")
    public String toFirstPage() {
        return "login&register/first";
    }

    @RequestMapping("/home")
    public String toConsumerHome() {
        System.out.println("我进来了...toConsumerHome");
        return "consumer/consumerhome";
    }

    @RequestMapping("/details")
    public String toDetails() {
        System.out.println("我进来了...toDetails");
        return "consumer/details";
    }

    @RequestMapping("/shopCart")
    public String toShopCart() {
        System.out.println("我进来了...shopCart");
        return "consumer/shopCart";
    }

    @RequestMapping("/PCenter")
    public String toPCenter() {
        System.out.println("我进来了...toPCenter");
        return "consumer/PCenter";
    }

    @RequestMapping("/pastOrder")
    public String toPastOrder() {
        System.out.println("我进来了...toPastOrder");
        return "consumer/pastOrder";
    }

    @RequestMapping("/assessment")
    public String toAssessment() {
        System.out.println("我进来了...toAssessment");
        return "consumer/assessment";
    }

    @RequestMapping("/discount")
    public String toDiscount() {
        System.out.println("我进来了...toDiscount");
        return "consumer/discount";
    }

    @RequestMapping("/PInfo")
    public String toPInfo() {
        System.out.println("我进来了...toPInfo");
        return "consumer/PInfo";
    }

}
