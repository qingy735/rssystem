package cn.edu.henu.controller;

import cn.edu.henu.bean.Business;
import cn.edu.henu.bean.Product;
import cn.edu.henu.service.IBusinessService;
import cn.edu.henu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Qing_Y
 */
@Controller
public class ActionController {

    @Autowired
    private IProductService productSer;
    @Autowired
    private IBusinessService businessSer;

    @RequestMapping("/first")
    public String toFirstPage() {
        return "login&register/first";
    }

    @RequestMapping("/home")
    public String toConsumerHome(HttpSession session) {
        List<Product> products = productSer.getAllProduct();
        if (products != null) {
            session.setAttribute("products", products);
        }
        return "consumer/consumerhome";
    }

    @RequestMapping("/details")
    public String toDetails(String id, String name, HttpSession session, Model model) {
        Integer username = null;
        try {
            name = new String(name.getBytes("iso-8859-1"), "utf-8");
            System.out.println(name);
            username = Integer.parseInt(id);
            Business business = businessSer.getOneByKey(username);
            if (business == null) {
                model.addAttribute("selectBusInfo", -1);
                return "consumer/details";
            }
            model.addAttribute("selectBusInfo", 1);
            model.addAttribute("business", business);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("selectBusInfo", -1);
            return "consumer/details";
        }
        List<Product> products = (List<Product>) session.getAttribute("products");
        System.out.println(products);
        for (Product product : products) {
            if (product.getBsId().equals(username) && product.getProductName().equals(name)) {
                model.addAttribute("product", product);
                break;
            }
        }
        return "consumer/details";
    }

    @RequestMapping("/shopCart")
    public String toShopCart() {
        return "consumer/shopCart";
    }

    @RequestMapping("/PCenter")
    public String toPCenter() {
        return "consumer/PCenter";
    }

    @RequestMapping("/pastOrder")
    public String toPastOrder() {
        return "consumer/pastOrder";
    }

    @RequestMapping("/assessment")
    public String toAssessment() {
        return "consumer/assessment";
    }

    @RequestMapping("/discount")
    public String toDiscount() {
        return "consumer/discount";
    }

    @RequestMapping("/PInfo")
    public String toPInfo() {
        return "consumer/PInfo";
    }

}
