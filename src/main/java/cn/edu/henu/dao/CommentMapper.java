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
    List<Comment> getAllByCid(String cid);

    /**
     * 根据用户和商品id查询
     *
     * @param cid
     * @param pid
     * @return
     */
    Comment getOneByCidAndPid(@Param("cid") String cid, @Param("pid") Integer pid);
}
