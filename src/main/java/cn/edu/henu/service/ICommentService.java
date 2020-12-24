package cn.edu.henu.service;

import cn.edu.henu.bean.Comment;
import cn.edu.henu.bean.PageBean;
import cn.edu.henu.bean.Comment;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-12-16 13:37
 */
public interface ICommentService {

    /**
     * 查询全部
     *
     * @return
     */
    List<Comment> getAll();

    /**
     * 根据餐品id查询所有评论
     *
     * @param pid
     * @return
     */
    List<Comment> getAllByPid(Integer pid);

    /**
     * 根据用户id查询所有评论
     *
     * @param cid
     * @return
     */
    List<Comment> getAllByCid(String cid);

    /**
     * 根据消费者和商品id查询
     *
     * @param cid
     * @param pid
     * @return
     */
    Comment getOne(String cid, Integer pid);

    /**
     * 给id为某值的商家添加评价
     *
     * @param comment
     * @return
     */
    int add(Comment comment);

    /**
     * 根据评价id删除
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 更新
     *
     * @param comment
     * @return
     */
    int update(Comment comment);
}
