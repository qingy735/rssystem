package cn.edu.henu.controller;

import cn.edu.henu.bean.*;
import cn.edu.henu.service.IAdminService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Qing_Y
 * @date 2020-12-07 23:22
 */
@Controller
@RequestMapping("/admin")
public class AdminUIController {

    @Autowired
    private IAdminService adminSer;

    final Integer ROW = 5;

    @RequestMapping("/orders")
    public String findAllOrder(@RequestParam(value = "p", defaultValue = "1") Integer p, Order order, HttpSession session) {
        String cid = order.getCid();
        Integer bid = order.getBid();
        Integer status = order.getStatus();
        Integer id = order.getId();
        boolean flag = false;

        if (cid != null && !"".equals(cid)) {
            flag = true;
        }
        if (bid != null && bid != 0) {
            flag = true;
        }
        if (status != null && status != 0) {
            flag = true;
        }
        if (id != null && id != 0) {
            flag = true;
        }
        // 分页
        PageHelper.startPage(p, ROW);
        // 创建PageBean对象
        PageBean<Order> pageBean;
        if (!flag) {
            session.removeAttribute("ordConds");
            pageBean = adminSer.findAllOrderByPage(null, ROW);
        } else {
            Map<String, Object> ordConds = new HashMap<>();
            ordConds.put("cid", cid);
            ordConds.put("bid", bid);
            ordConds.put("status", status);
            ordConds.put("id", id);
            session.setAttribute("ordConds", ordConds);
            if ("".equals(cid)) {
                order.setCid(null);
            }
            pageBean = adminSer.findAllOrderByPage(order, ROW);
        }
        pageBean.setCurrentPage(p);
        session.setAttribute("pageOrder", pageBean);
        return "admin/orderAd";
    }

    @RequestMapping("/comments")
    public String findAllComment() {
        adminSer.findAllComment();
        return "admin/commentAd";
    }

    @RequestMapping("/businesses")
    public String findAllBusiness(@RequestParam(value = "p", defaultValue = "1") Integer p, Business business, HttpSession session) {
        Integer username = business.getUsername();
        String wname = business.getWname();
        String rname = business.getRname();
        Float grade = business.getGrade();
        boolean flag = false;
        if (wname != null && !"".equals(wname)) {
            business.setWname("%" + wname + "%");
            flag = true;
        }
        if (rname != null && !"".equals(rname)) {
            business.setRname("%" + rname + "%");
            flag = true;
        }
        if (grade != null && grade != 0f) {
            flag = true;
        }
        if (username != null && username != 0) {
            flag = true;
        }
        // 分页
        PageHelper.startPage(p, ROW);
        // 创建PageBean对象
        PageBean<Business> pageBean;
        if (!flag) {
            session.removeAttribute("busConds");
            pageBean = adminSer.findAllBusinessByPage(null, ROW);
        } else {
            Map<String, Object> busConds = new HashMap<>();
            busConds.put("wname", wname);
            busConds.put("rname", rname);
            busConds.put("grade", grade);
            busConds.put("username", username);
            session.setAttribute("busConds", busConds);
            if ("".equals(wname)) {
                business.setWname(null);
            }
            if ("".equals(rname)) {
                business.setRname(null);
            }
            pageBean = adminSer.findAllBusinessByPage(business, ROW);
        }
        pageBean.setCurrentPage(p);
        session.setAttribute("pageBus", pageBean);

        return "admin/buAdmin";
    }

    @RequestMapping("/consumers")
    public String findAllConsumer(@RequestParam(value = "p", defaultValue = "1") Integer p, Consumer consumer, HttpSession session) {
        String username = consumer.getUsername();
        String nickname = consumer.getNickname();
        Integer sex = consumer.getSex();
        String name = consumer.getName();
        boolean flag = false;
        if (username != null && !"".equals(username)) {
            flag = true;
        }
        if (nickname != null && !"".equals(nickname)) {
            consumer.setNickname("%" + nickname + "%");
            flag = true;
        }
        if (name != null && !"".equals(name)) {
            consumer.setName("%" + name + "%");
            flag = true;
        }
        if (sex != null && sex != 0) {
            flag = true;
        }
        // 分页
        PageHelper.startPage(p, ROW);
        // 创建PageBean对象
        PageBean<Consumer> pageBean;
        if (!flag) {
            session.removeAttribute("conConds");
            pageBean = adminSer.findAllConsumerByPage(null, ROW);
        } else {
            Map<String, Object> conConds = new HashMap<>();
            conConds.put("username", username);
            conConds.put("nickname", nickname);
            conConds.put("name", name);
            conConds.put("sex", sex);
            session.setAttribute("conConds", conConds);
            if ("".equals(username)) {
                consumer.setUsername(null);
            }
            if ("".equals(nickname)) {
                consumer.setNickname(null);
            }
            if ("".equals(name)) {
                consumer.setName(null);
            }
            pageBean = adminSer.findAllConsumerByPage(consumer, ROW);
        }
        pageBean.setCurrentPage(p);
        session.setAttribute("pageCon", pageBean);
        return "admin/conAdmin";
    }

    @RequestMapping("/home")
    public String toHome(HttpSession session) {
        Admin admLoginInfo = (Admin) session.getAttribute("admLoginInfo");
        if (admLoginInfo == null) {
            return "redirect:/login/admin";
        }
        return "admin/adminhome";
    }

}
