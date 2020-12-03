package cn.edu.henu.controller;

import cn.edu.henu.bean.Product;
import cn.edu.henu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * @author Qing_Y
 * @date 2020-12-03 14:59
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productSer;

    @RequestMapping("/add")
    public String add(Product product, Integer bid, HttpSession session) throws UnsupportedEncodingException {
        String productName = product.getProductName();
        productName = new String(productName.getBytes("iso-8859-1"), "utf-8");
        product.setProductName(productName);
        System.out.println(product);
        System.out.println(bid);
        /*int i = productSer.add(product, bid);
        if (i <= 0) {
            session.setAttribute("addPInfo", "插入失败");
            return "redirect:/updateProducts";
        }*/
        return "redirect:/business/home";
    }
}
