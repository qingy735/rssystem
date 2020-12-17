package cn.edu.henu.controller;

import cn.edu.henu.bean.Business;
import cn.edu.henu.bean.Product;
import cn.edu.henu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
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
            return "redirect:/business/uploadProducts";
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
            if (i < 1) {
                session.setAttribute("addPInfo", "插入失败");
                return "redirect:/business/uploadProducts";
            }
            return "redirect:/business/productList";
        } catch (IOException e) {
            e.printStackTrace();
            session.setAttribute("addPInfo", "插入失败");
            return "redirect:/business/uploadProducts";
        }
    }

    @RequestMapping("/delete")
    public String delete(Integer id, HttpSession session) throws Exception {
        Product product = productSer.selectSimpleById(id);
        int i = productSer.deleteById(id);
        if (i < 1) {
            session.setAttribute("delInfo", "删除失败");
            throw new Exception();
        } else {
            // 删除图片
            String photosrc = product.getPhotosrc();
            String realPath = session.getServletContext().getRealPath(photosrc);
            File file = new File(realPath);
            boolean delete = file.delete();
            if (!delete) {
                session.setAttribute("delInfo", "删除失败");
            }
        }
        return "redirect:/business/productList";
    }

    @RequestMapping("/update")
    public String update(Product product, @RequestParam("imgSrc") MultipartFile file, HttpSession session) {
        Object updateInfo = session.getAttribute("updateInfo");
        if (updateInfo != null) {
            session.removeAttribute("updateInfo");
        }
        if (!file.isEmpty()) {
            // 获取当前图片地址
            Integer id = product.getId();
            String photosrc = productSer.selectSimpleById(id).getPhotosrc();
            String realPath = session.getServletContext().getRealPath(photosrc);
            File oldFile = new File(realPath);
            boolean delete = oldFile.delete();
            if (!delete) {
                session.setAttribute("updateInfo", "更新失败");
                return "redirect:/business/updateProducts";
            }
            File newFile = new File(realPath);
            try {
                file.transferTo(newFile);
                int i = productSer.updateById(product);
                if (i < 1) {
                    session.setAttribute("updateInfo", "更新失败");
                    return "redirect:/business/updateProducts";
                }
                return "redirect:/business/productList";
            } catch (IOException e) {
                e.printStackTrace();
                session.setAttribute("updateInfo", "更新失败");
                return "redirect:/business/updateProducts";
            }
        } else {
            int i = productSer.updateById(product);
            if (i < 1) {
                session.setAttribute("updateInfo", "更新失败");
                return "redirect:/business/updateProducts";
            }
            return "redirect:/business/productList";
        }
    }

}
