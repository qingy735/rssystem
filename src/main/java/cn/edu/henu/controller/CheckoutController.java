package cn.edu.henu.controller;

import cn.edu.henu.bean.Consumer;
import cn.edu.henu.bean.Order;
import cn.edu.henu.bean.OrderDetail;
import cn.edu.henu.bean.Shop;
import cn.edu.henu.service.ICheckoutService;
import cn.edu.henu.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author Qing_Y
 * @date 2020-12-15 19:51
 */
@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private ICheckoutService checkoutSer;
    @Autowired
    private IShopService shopSer;

    @RequestMapping("/shop")
    public String checkFromShop(Integer id, HttpSession session, HttpServletRequest request) {
        String referer = request.getHeader("REFERER");
        System.out.println(referer);
        Consumer consumer = (Consumer) session.getAttribute("conLoginInfo");
        if (consumer == null) {
            return "redirect:/login/consumer";
        }
        if (referer == null || !referer.contains("shopCart")) {
            return "redirect:/shopCart";
        }
        Shop shop = shopSer.selectByPrimaryKey(id);
        OrderDetail detail = new OrderDetail();
        detail.setPid(shop.getPid());
        detail.setNum(shop.getPnum());
        detail.setDiscount(shop.getDiscountuse());
        Order order = new Order();
        order.setCid(consumer.getUsername());
        order.setBid(shop.getBid());
        String code = UUID.randomUUID().toString().replace("-", "").substring(5, 9);
        order.setCode(code);

        List<OrderDetail> details = new ArrayList<>();
        details.add(detail);
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        try {
            int checkout = checkoutSer.checkout(order, details, ids);
            if (checkout < 1) {
                session.setAttribute("checkoutInfo", "结账失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("checkoutInfo", "结账失败");
        }
        return "redirect:/pastOrder";
    }

    @ResponseBody
    @RequestMapping("/shops")
    public Map<String, Object> checkFromShop(Integer[] ids, HttpSession session, HttpServletRequest request) {
        Map<String, Object> info = new HashMap<>();
        String referer = request.getHeader("REFERER");
        Consumer consumer = (Consumer) session.getAttribute("conLoginInfo");
        if (consumer == null) {
            info.put("flag", false);
            info.put("href", "/login/consumer");
            return info;
        }
        if (referer == null || !referer.contains("shopCart")) {
            info.put("flag", false);
            info.put("href", "/shopCart");
            return info;
        }

        Order order = new Order();
        order.setCid(consumer.getUsername());
        List<OrderDetail> details = new ArrayList<>();
        List<Integer> idss = new ArrayList<>(Arrays.asList(ids));
        for (int i : ids) {
            Shop shop = shopSer.selectByPrimaryKey(i);
            order.setBid(shop.getBid());
            OrderDetail detail = new OrderDetail();
            detail.setPid(shop.getPid());
            detail.setNum(shop.getPnum());
            detail.setDiscount(shop.getDiscountuse());
            details.add(detail);
            String code = UUID.randomUUID().toString().replace("-", "").substring(5, 9);
            order.setCode(code);
        }

        try {
            int checkout = checkoutSer.checkout(order, details, idss);
            if (checkout < 1) {
                info.put("flag", false);
                info.put("href", "/shopCart");
            } else {
                info.put("flag", true);
                info.put("href", "/pastOrder");
            }
        } catch (Exception e) {
            e.printStackTrace();
            info.put("flag", false);
            info.put("href", "/shopCart");
        }
        return info;
    }

}
