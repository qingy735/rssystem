package cn.edu.henu.service;

import cn.edu.henu.bean.Shop;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-12-13 17:51
 */
public interface IShopService {
    /**
     * 添加商品进入购物车
     *
     * @param shop
     * @return
     */
    int insert(Shop shop);

    /**
     * 根据id删除购物车里的商品
     * or
     * 结账后消失
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 更改购物车里商品内容
     *
     * @param shop
     * @return
     */
    int update(Shop shop);

    /**
     * 查询所有购物车内容
     *
     * @return
     */
    List<Shop> selectAll();

    /**
     * 根据消费者id查询所有购物车内容
     *
     * @param cid
     * @return
     */
    List<Shop> selectByCid(String cid);
}
