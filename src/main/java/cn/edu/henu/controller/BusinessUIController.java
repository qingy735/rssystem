package cn.edu.henu.controller;

import cn.edu.henu.bean.Business;
import cn.edu.henu.bean.Order;
import cn.edu.henu.bean.Product;
import cn.edu.henu.service.IBusinessService;
import cn.edu.henu.service.IOrderService;
import cn.edu.henu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用于商家页面跳转的Controller
 *
 * @author Qing_Y
 * @date 2020-12-03 21:14
 */
@Controller
@RequestMapping("")
public class BusinessUIController {

    @Autowired
    private IProductService productSer;
    @Autowired
    private IBusinessService businessSer;
    @Autowired
    private IOrderService orderSer;

    @RequestMapping("/business/top")
    public String toTop() {
        return "/business/top";
    }

    @RequestMapping("/business/left")
    public String toLeft() {
        return "/business/left";
    }

    @RequestMapping("/Buinfo")
    public String toBuinfo() {
        return "/business/Buinfo";
    }

    @RequestMapping("/updateProducts")
    public String toUpdateProducts() {
        return "/business/updateProducts";
    }

    @RequestMapping("/orderList")
    public String toOrderList(HttpSession session) {
        Business business = (Business) session.getAttribute("busLoginInfo");
        if (business != null) {
            List<Order> orders = orderSer.selectByBid(business.getUsername());
            session.setAttribute("orders", orders);
        }
        return "/business/orderList";
    }

    @RequestMapping("/productList")
    public String toProductList(HttpSession session) {
        Business business = (Business) session.getAttribute("busLoginInfo");
        if (business != null) {
            List<Product> products = productSer.getAllByBid(business.getUsername());
            session.setAttribute("products", products);
        }
        return "/business/ProductsList";
    }

    @RequestMapping("/orderDetail")
    public String toOrderDetail(String oid, @RequestHeader("Referer") String referer, Model model, HttpSession session) {
        if (referer.contains("/orderList")) {
            List<Order> orders = (List<Order>) session.getAttribute("orders");
            if (orders != null) {
                for (Order order : orders) {
                    if (order.getOrderId().equals(oid)) {
                        model.addAttribute("order", order);
                        return "/business/orderDetail";
                    }
                }
            }
            return "redirect:business/home";
        } else {
            return "redirect:/login/business";
        }
    }

    @RequestMapping("/uploadProducts")
    public String toUpdateProducts(HttpSession session, Model model) {
        String pInfo = (String) session.getAttribute("addPInfo");
        if (pInfo != null) {
            session.removeAttribute("addPInfo");
            model.addAttribute("add_msg", pInfo);
        }
        return "business/uploadProducts";
    }

}
