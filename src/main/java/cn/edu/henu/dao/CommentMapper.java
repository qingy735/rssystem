package cn.edu.henu.dao;

import cn.edu.henu.bean.Comment;
import cn.edu.henu.bean.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-12-16 13:32
 */
public interface CommentMapper extends CrudDao<Comment> {

    /**
     * 查询所有商品
     *
     * @return
     */
    List<Comment> selectAll();

    /**
     * 获取商品信息
     *
     * @param id
     * @return
     */
    Comment selectById(Integer id);

    /**
     * 仅仅获取商品信息
     *
     * @param id
     * @return
     */
    Comment selectSimpleById(Integer id);

    /**
     * 仅仅获取商品信息
     *
     * @return
     */
    List<Comment> selectAllSimple();

    /**
     * 根据条件(如果有)查询条目
     *
     * @param product
     * @return
     */
    int selectTotal(Comment product);

    /**
     * 根据商家id获取商品信息
     *
     * @param bid
     * @return
     */
    List<Comment> getAllByBid(Integer bid);
    /**
     * 根据餐品id获取商品信息
     *
     * @param pid
     * @return
     */
    List<Comment> getAllByPid(Integer pid);
    /**
     * 根据消费者id获取商品信息
     *
     * @param cid
     * @return
     */
    List<Comment> getAllByCid(Integer cid);

    /**
     * 根据商家id和条件获取商品信息
     *
     * @param cid
     * @param pid
     * @return
     */
    List<Comment> getAllByCidAndName(@Param("cid") Integer cid, @Param("pid") String pid);
}
