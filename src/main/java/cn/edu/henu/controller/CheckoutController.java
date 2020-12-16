package cn.edu.henu.controller;

import cn.edu.henu.bean.Consumer;
import cn.edu.henu.bean.Order;
import cn.edu.henu.bean.OrderDetail;
import cn.edu.henu.bean.Shop;
import cn.edu.henu.service.ICheckoutService;
import cn.edu.henu.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

}
