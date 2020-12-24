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
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 批量删除
     * 用于结账
     *
     * @param ids
     * @return
     */
    int batchDelete(List<Integer> ids);

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
     * 根据商品id查询
     *
     * @param pid
     * @return
     */
    Shop selectByPid(Integer pid);

    /**
     * 根据消费者id查询所有购物车内容
     *
     * @param cid
     * @return
     */
    List<Shop> selectByCid(String cid);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Shop selectByPrimaryKey(Integer id);

    /**
     * 批量查询
     *
     * @param ids
     * @return
     */
    List<Shop> batchSelect(List<Integer> ids);
}
