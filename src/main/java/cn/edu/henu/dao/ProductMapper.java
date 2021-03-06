package cn.edu.henu.dao;

import cn.edu.henu.bean.Product;
import org.apache.ibatis.annotations.Param;

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
     * 获取商品信息
     *
     * @param id
     * @return
     */
    Product selectById(Integer id);

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
     * 根据条件(如果有)查询条目
     *
     * @param product
     * @return
     */
    int selectTotal(Product product);

    /**
     * 根据商家id获取商品信息
     *
     * @param bid
     * @return
     */
    List<Product> getAllByBid(Integer bid);

    /**
     * 根据商家id和条件获取商品信息
     *
     * @param bid
     * @param pname
     * @return
     */
    List<Product> getAllByBidAndName(@Param("bid") Integer bid, @Param("pname") String pname);

    /**
     * 求对应店铺的平均评分
     *
     * @param bid
     * @return
     */
    Float getAvg(Integer bid);
}
