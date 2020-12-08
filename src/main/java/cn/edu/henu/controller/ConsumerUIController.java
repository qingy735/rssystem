package cn.edu.henu.controller;

import cn.edu.henu.bean.*;
import cn.edu.henu.service.IBusinessService;
import cn.edu.henu.service.IOrderService;
import cn.edu.henu.service.IProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于消费者页面跳转的Controller
 *
 * @author Qing_Y
 * @date 2020-12-03 21:10
 */
@Controller
@RequestMapping("")
public class ConsumerUIController {

    @Autowired
    private IProductService productSer;
    @Autowired
    private IBusinessService businessSer;
    @Autowired
    private IOrderService orderSer;

    final Integer ROW = 8;
    private String username;

    @RequestMapping("/home")
    public String toConsumerHome(Product product, @RequestParam(value = "p", defaultValue = "1") Integer p, HttpSession session) {
        String name = product.getProductName();
        Float price = product.getProductPrice();
        Float grade = product.getProductGrade();
        boolean flag = false;

        if (name != null && !"".equals(name)) {
            flag = true;
        }
        if (price != null && price != 0f) {
            flag = true;
        }
        if (grade != null && grade != 0f) {
            flag = true;
        }

        // 分页,一页八个
        PageHelper.startPage(p, ROW);
        // 创建PageBean对象
        PageBean<Product> pageBean;
        if (!flag) {
            session.removeAttribute("conds");
            pageBean = productSer.getAllProducts(null, ROW);
        } else {
            Map<String, Object> conds = new HashMap<>();
            conds.put("name", name);
            conds.put("price", price);
            conds.put("grade", grade);
            session.setAttribute("conds", conds);
            if ("".equals(name)) {
                product.setProductName(null);
            }
            product.setProductName("%" + name + "%");
            pageBean = productSer.getAllProducts(product, ROW);
        }
        pageBean.setCurrentPage(p);
        session.setAttribute("pb", pageBean);
        return "consumer/consumerhome";
    }

    @RequestMapping("/details")
    public String toDetails(String id, String name, HttpSession session, Model model) {
        Integer username;
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
        List<Product> products = ((PageBean<Product>) session.getAttribute("pb")).getList();
        System.out.println(products);
        for (Product product : products) {
            if (product.getBusiness().getUsername().equals(username) && product.getProductName().equals(name)) {
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
    public String toPCenter(HttpSession session) {
        Consumer consumer = (Consumer) session.getAttribute("conLoginInfo");
        if (consumer == null) {
            session.setAttribute("login_info", "请先登录");
            return "redirect:/login/consumer";
        }
        return "consumer/PCenter";
    }

    @RequestMapping("/pastOrder")
    public String toPastOrder(HttpSession session) {
        Consumer consumer = (Consumer) session.getAttribute("conLoginInfo");
        if (consumer == null) {
            session.setAttribute("login_info", "请先登录");
            return "redirect:/login/business";
        }
        String username = consumer.getUsername();
        List<Order> orders = orderSer.selectByCid(username);
        session.setAttribute("conOrders", orders);
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
