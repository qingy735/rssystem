package cn.edu.henu.controller;

import cn.edu.henu.bean.Business;
import cn.edu.henu.bean.Order;
import cn.edu.henu.bean.Product;
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
@RequestMapping("/business")
public class BusinessUIController {

    @Autowired
    private IProductService productSer;
    @Autowired
    private IOrderService orderSer;

    @RequestMapping("/top")
    public String toTop() {
        return "/business/top";
    }

    @RequestMapping("/left")
    public String toLeft() {
        return "/business/left";
    }

    @RequestMapping("/Buinfo")
    public String toBuinfo() {
        return "/business/Buinfo";
    }

    @RequestMapping("/updateProducts")
    public String toUpdateProducts(Integer id, Model model) {
        Product product = productSer.selectSimpleById(id);
        model.addAttribute("updateProduct", product);
        return "/business/updateProducts";
    }

    @RequestMapping("/productList")
    public String toProductList(String name, HttpSession session, Model model) {
        Business business = (Business) session.getAttribute("busLoginInfo");
        if (business == null) {
            return "redirect:/login/business";
        }
        if ("".equals(name)) {
            name = null;
        }
        if (name != null) {
            model.addAttribute("name", name);
            name = "%" + name + "%";
        }
        List<Product> products = productSer.getAllByBidAndName(business.getUsername(), name);
        session.setAttribute("products", products);
        String delInfo = (String) session.getAttribute("delInfo");
        if (delInfo != null) {
            session.removeAttribute("delInfo");
            model.addAttribute("delInfo", delInfo);
        }
        return "/business/ProductsList";
    }

    @RequestMapping("/orderList")
    public String toOrderList(HttpSession session) {
        Business business = (Business) session.getAttribute("busLoginInfo");
        if (business != null) {
            List<Order> orders = orderSer.selectByBid(business.getUsername());
            session.setAttribute("busOrders", orders);
        }
        return "/business/orderList";
    }

    @RequestMapping("/orderDetail")
    public String toOrderDetail(Integer oid, @RequestHeader("Referer") String referer, Model model, HttpSession session) {
        if (referer.contains("/orderList")) {
            List<Order> orders = (List<Order>) session.getAttribute("orders");
            if (orders != null) {
                for (Order order : orders) {
                    if (order.getId().equals(oid)) {
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

    @RequestMapping("/message")
    public String toMessage() {
        return "/business/message";
    }

}
