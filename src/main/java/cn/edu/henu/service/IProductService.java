package cn.edu.henu.service;

import cn.edu.henu.bean.Condition;
import cn.edu.henu.bean.PageBean;
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
    PageBean<Product> getAllProduct();

    /**
     * 根据条件查询
     *
     * @param condition
     * @return
     */
    PageBean<Product> getAllByCondition(Condition condition);

    /**
     * 根据商家id查询商品
     *
     * @param bid
     * @return
     */
    List<Product> getAllByBid(Integer bid);

    /**
     * 查询一共多少条数据
     *
     * @param condition
     * @return
     */
    int getTotal(Condition condition);

    /**
     * 给id为某值的商家添加商品
     *
     * @param product
     * @return
     */
    int add(Product product);

}
