package cn.edu.henu.service;

import cn.edu.henu.bean.Comment;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-12-16 13:37
 */
public interface ICommentService {

    /**
     * 添加评论
     *
     * @param comment
     * @return
     */
    int add(Comment comment);

    /**
     * 删除评论
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 根据商品id查询所有评论
     *
     * @param pid
     * @return
     */
    List<Comment> selectByPid(Integer pid);

    /**
     * 根据用户id查询所有评论
     *
     * @param cid
     * @return
     */
    List<Comment> selectByCid(String cid);

}
