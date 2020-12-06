package cn.edu.henu.dao;

import cn.edu.henu.bean.Condition;
import cn.edu.henu.bean.Product;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-11-26 19:05
 */
public interface ProductMapper extends CrudDao<Product> {
    /**
     * 查询所有商品
     *
     * @return
     */
    List<Product> selectAll();

    /**
     * 仅仅获取商品信息
     *
     * @param id
     * @return
     */
    Product selectSimpleById(Integer id);

    /**
     * 仅仅获取商品信息
     *
     * @return
     */
    List<Product> selectAllSimple();

    /**
     * 根据商品信息查询
     *
     * @param condition
     * @return
     */
    List<Product> selectByCondition(Condition condition);

    /**
     * 查询条目
     *
     * @param condition
     * @return
     */
    int selectTotal(Condition condition);

    /**
     * 根据商家id获取商品信息
     *
     * @param bid
     * @return
     */
    List<Product> getAllByBid(Integer bid);
}
