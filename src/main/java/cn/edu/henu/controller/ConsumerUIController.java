package cn.edu.henu.controller;

import cn.edu.henu.bean.*;
import cn.edu.henu.service.IBusinessService;
import cn.edu.henu.service.IOrderService;
import cn.edu.henu.service.IProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private IOrderService orderSer;

    final Integer ROW = 8;

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
    public String toDetails(Integer pid, HttpSession session, Model model) {
        String add_info = (String) session.getAttribute("add_info");
        if (add_info != null) {
            session.removeAttribute("add_info");
            model.addAttribute("add_info", add_info);
        }
        PageBean<Product> pageBean = ((PageBean<Product>) session.getAttribute("pb"));
        if (pageBean == null) {
            return "redirect:/home";
        }
        List<Product> products = pageBean.getList();
        boolean flag = false;
        for (Product product : products) {
            if (product.getId().equals(pid)) {
                model.addAttribute("product", product);
                flag = true;
                break;
            }
        }
        model.addAttribute("error_info", flag);
        return "consumer/details";
    }

    @RequestMapping("/shopCart")
    public String toShopCart(HttpSession session, HttpServletRequest request) {
        Consumer consumer = (Consumer) session.getAttribute("conLoginInfo");
        if (consumer == null) {
            String url = request.getRequestURL().toString();
            session.setAttribute("history", url);
            session.setAttribute("login_info", "请先登录");
            return "redirect:/login/consumer";
        }
        return "consumer/shopCart";
    }

    @RequestMapping("/PCenter")
    public String toPCenter(HttpSession session, HttpServletRequest request) {
        Consumer consumer = (Consumer) session.getAttribute("conLoginInfo");
        if (consumer == null) {
            String url = request.getRequestURL().toString();
            session.setAttribute("history", url);
            session.setAttribute("login_info", "请先登录");
            return "redirect:/login/consumer";
        }
        return "consumer/PCenter";
    }

    @RequestMapping("/pastOrder")
    public String toPastOrder(HttpSession session, HttpServletRequest request) {
        Consumer consumer = (Consumer) session.getAttribute("conLoginInfo");
        if (consumer == null) {
            String url = request.getRequestURL().toString();
            session.setAttribute("history", url);
            session.setAttribute("login_info", "请先登录");
            return "redirect:/login/consumer";
        }
        String username = consumer.getUsername();
        List<Order> orders = orderSer.selectByCid(username);
        session.setAttribute("conOrders", orders);
        return "consumer/pastOrder";
    }

    @RequestMapping("/assessment")
    public String toAssessment(HttpSession session, HttpServletRequest request) {
        Consumer consumer = (Consumer) session.getAttribute("conLoginInfo");
        if (consumer == null) {
            String url = request.getRequestURL().toString();
            session.setAttribute("history", url);
            session.setAttribute("login_info", "请先登录");
            return "redirect:/login/consumer";
        }
        return "consumer/assessment";
    }

    @RequestMapping("/discount")
    public String toDiscount(HttpSession session, HttpServletRequest request) {
        Consumer consumer = (Consumer) session.getAttribute("conLoginInfo");
        if (consumer == null) {
            String url = request.getRequestURL().toString();
            session.setAttribute("history", url);
            session.setAttribute("login_info", "请先登录");
            return "redirect:/login/consumer";
        }
        return "consumer/discount";
    }

    @RequestMapping("/PInfo")
    public String toPInfo(HttpSession session, HttpServletRequest request) {
        Consumer consumer = (Consumer) session.getAttribute("conLoginInfo");
        if (consumer == null) {
            String url = request.getRequestURL().toString();
            session.setAttribute("history", url);
            session.setAttribute("login_info", "请先登录");
            return "redirect:/login/consumer";
        }
        return "consumer/PInfo";
    }

}
