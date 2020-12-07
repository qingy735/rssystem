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
     * 查询所有商品 有条件就按照条件查
     *
     * @param product
     * @param row
     * @return
     */
    PageBean<Product> getAllProducts(Product product, Integer row);

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
     * @param product
     * @return
     */
    int getTotal(Product product);

    /**
     * 给id为某值的商家添加商品
     *
     * @param product
     * @return
     */
    int add(Product product);

    /**
     * 根据商品id更新
     *
     * @param product
     * @return
     */
    int updateById(Product product);

    /**
     * 根据商品id删除
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 根据商品id查询简单商品信息
     *
     * @param id
     * @return
     */
    Product selectSimpleById(Integer id);

}
