package cn.edu.henu.service.impl;

import cn.edu.henu.bean.Condition;
import cn.edu.henu.bean.PageBean;
import cn.edu.henu.bean.Product;
import cn.edu.henu.dao.ProductMapper;
import cn.edu.henu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-11-26 21:31
 */
@Service("productSer")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    void initPageBean(PageBean<Product> pageBean, Condition condition) {
        pageBean.setRows(5);
        int total = getTotal(condition);
        pageBean.setTotalCount(total);
        int rows = pageBean.getRows();
        int a = total % rows;
        int b = total / rows;
        pageBean.setTotalPage(a == 0 ? b : b + 1);
    }

    @Override
    public PageBean<Product> getAllProduct() {
        try {
            List<Product> products = productMapper.selectAll();
            PageBean<Product> pageBean = new PageBean<>();
            initPageBean(pageBean, new Condition());
            pageBean.setList(products);
            return pageBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PageBean<Product> getAllByCondition(Condition condition) {
        try {
            List<Product> products = productMapper.selectByCondition(condition);
            PageBean<Product> pageBean = new PageBean<>();
            initPageBean(pageBean, condition);
            pageBean.setList(products);
            return pageBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getTotal(Condition condition) {
        try {
            return productMapper.selectTotal(condition);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
