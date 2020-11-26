package cn.edu.henu.service;

import cn.edu.henu.bean.Product;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-11-26 21:30
 */
public interface IProductService {

    /**
     * 获得包含所有商品信息的集合
     *
     * @return
     */
    List<Product> getAllProduct();

}
