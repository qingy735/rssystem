package cn.edu.henu.controller;

import cn.edu.henu.bean.*;
import cn.edu.henu.service.IOrderService;
import cn.edu.henu.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-12-13 17:54
 */
@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private IShopService shopSer;
    @Autowired
    private IOrderService orderSer;

    @RequestMapping("/add")
    public String add(Shop shop, HttpSession session, HttpServletRequest request) {
        // 获取消费者id
        Consumer conLoginInfo = (Consumer) session.getAttribute("conLoginInfo");
        if (conLoginInfo == null) {
            String url = request.getHeader("referer");
            System.out.println(url);
            session.setAttribute("history", url);
            session.setAttribute("login_info", "请先登录");
            return "redirect:/login/consumer";
        }
        shop.setCid(conLoginInfo.getUsername());

        int i = shopSer.insert(shop);
        if (i < 1) {
            session.setAttribute("add_info", "添加订单失败");
            Integer pid = shop.getPid();
            return "redirect:/details?pid=" + pid;
        }
        return "redirect:/shopCart";
    }

    @RequestMapping("/delete")
    public String delete(Integer id, HttpSession session) {
        int delete = shopSer.delete(id);
        if (delete < 1) {
            session.setAttribute("errorInfo", "移除购物车失败");
        }
        return "redirect:/shopCart";
    }

    @RequestMapping("/update")
    public String update(Shop shop, HttpSession session) {
        int update = shopSer.update(shop);
        if (update < 1) {
            session.setAttribute("errorInfo", "更新购物车失败");
        }
        return "redirect:/shopCart";
    }

    @RequestMapping("/checkout")
    public String checkout(Integer id, Model model, HttpSession session) {
        List<Shop> shops = (List<Shop>) session.getAttribute("shops");
        Shop s = null;
        if (shops != null) {
            for (Shop shop : shops) {
                if (shop.getId().equals(id)) {
                    s = shop;
                    break;
                }
            }
        } else {
            s = shopSer.selectByPrimaryKey(id);
        }
        model.addAttribute("shop", s);
        return "consumer/checkoutPage";
    }

}