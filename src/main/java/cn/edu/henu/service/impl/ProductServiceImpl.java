package cn.edu.henu.service.impl;

import cn.edu.henu.bean.Product;
import cn.edu.henu.dao.ProductMapper;
import cn.edu.henu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<Product> getAllProduct() {
        try {
            return productMapper.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
