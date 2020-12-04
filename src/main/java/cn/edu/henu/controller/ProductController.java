package cn.edu.henu.controller;

import cn.edu.henu.bean.Product;
import cn.edu.henu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

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
    public String add(Product product, @RequestParam("imgSrc") MultipartFile file, HttpSession session) {
        if (file.isEmpty()) {
            session.setAttribute("addPInfo", "插入失败");
            return "redirect:/business/updateProducts";
        }
        System.out.println(file.getOriginalFilename());
        String fileSuffix = file.getOriginalFilename().split("\\.")[1];
        String fileName = UUID.randomUUID().toString()
                .substring(0, 8)
                .replace("-", "_");
        String path = "images/products";
        String realPath = session.getServletContext().getRealPath(path);
        String realName = fileName + "." + fileSuffix;
        File target = new File(realPath + "/" + realName);
        try {
            file.transferTo(target);
            product.setPhotosrc(path + "/" + realName);
            int i = productSer.add(product);
            if (i <= 0) {
                session.setAttribute("addPInfo", "插入失败");
                return "redirect:/business/updateProducts";
            }
            return "redirect:/business/home";
        } catch (IOException e) {
            e.printStackTrace();
            session.setAttribute("addPInfo", "插入失败");
            return "redirect:/business/updateProducts";
        }
    }
}
