package cn.edu.henu.dao;

import cn.edu.henu.bean.Shop;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-12-13 17:31
 */
public interface ShopMapper extends CrudDao<Shop> {

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

    /**
     * 根据商品id查找
     *
     * @param pid
     * @return
     */
    Shop selectByPid(Integer pid);

    /**
     * 批量删除购物车数据
     *
     * @param ids
     * @return
     */
    int batchDelete(List<Integer> ids);

    /**
     * 批量查询
     *
     * @param ids
     * @return
     */
    List<Shop> batchSelect(List<Integer> ids);

}
