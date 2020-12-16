package cn.edu.henu.dao;

import cn.edu.henu.bean.Comment;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-12-16 13:32
 */
public interface CommentMapper extends CrudDao<Comment> {

    /**
     * 根据id删除评论
     *
     * @param id
     * @return
     */
    @Override
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加评论
     *
     * @param entity
     * @return
     */
    @Override
    int insert(Comment entity);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    Comment selectByPrimaryKey(Integer id);

    /**
     * 根据商品id查询评论
     *
     * @param pid
     * @return
     */
    List<Comment> selectByPid(Integer pid);

    /**
     * 根据用户id查询评论
     *
     * @param cid
     * @return
     */
    List<Comment> selectByCid(String cid);

}
