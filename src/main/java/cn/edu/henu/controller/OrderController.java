package cn.edu.henu.controller;

import cn.edu.henu.bean.Consumer;
import cn.edu.henu.bean.Order;
import cn.edu.henu.bean.PageBean;
import cn.edu.henu.bean.Product;
import cn.edu.henu.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Qing_Y
 * @date 2020-12-09 13:51
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderSer;

    @RequestMapping("/update")
    public String updateStatus(Order order, HttpSession session) {
        System.out.println(order);
        int i = orderSer.updateByPrimaryKey(order);
        if (i < 1) {
            session.setAttribute("updateInfo", "订单结账失败");
        }
        return "redirect:/pastOrder";
    }

    /*@RequestMapping("/add")
    public String add(Order order, HttpSession session, HttpServletRequest request) {
        Integer pid = order.getPid();
        // 获取店铺id
        List<Product> products = ((PageBean<Product>) session.getAttribute("pb")).getList();
        for (Product product : products) {
            if (product.getId().equals(pid)) {
                order.setBid(product.getBid());
                break;
            }
        }
        // 获取消费者id
        Consumer conLoginInfo = (Consumer) session.getAttribute("conLoginInfo");
        if (conLoginInfo == null) {
            String url = request.getHeader("referer");
            System.out.println(url);
            session.setAttribute("history", url);
            session.setAttribute("login_info", "请先登录");
            return "redirect:/login/consumer";
        }
        order.setCid(conLoginInfo.getUsername());
        // 获取取餐码
        String code = UUID.randomUUID().toString().replaceAll("-", "").substring(4, 8);
        order.setCode(code);

        int i = orderSer.addOrder(order);
        if (i < 1) {
            session.setAttribute("add_info", "添加订单失败");
            return "redirect:/details?pid=" + pid;
        }

        return "redirect:/pastOrder";
    }*/

    /**
     * 结账
     *
     * @param body
     * @param session
     * @return
     */
    /*@ResponseBody
    @RequestMapping("/checkout")
    public Map<String, Object> checkout(@RequestBody Order body, HttpSession session) {
        int oid = body.getOrderId();
        int status = body.getStatus();
        Map<String, Object> info = new HashMap<>();
        int i = orderSer.updateStatusByOid(oid, status);
        if (i == 1) {
            // 更新session中的订单信息
            List<Order> orders = (List<Order>) session.getAttribute("conOrders");
            for (Order o : orders) {
                if (o.getOrderId() == oid) {
                    o.setStatus(status);
                    break;
                }
            }
            session.setAttribute("conOrders", orders);
        }
        info.put("flag", i);
        return info;
    }*/

}
