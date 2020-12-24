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
     * 查询所有评价 有条件就按照条件查
     *
     * @param comment
     * @param row
     * @return
     */
    PageBean<Comment> getAllComments(Comment comment, Integer row);

    /**
     * 根据商家id查询评价
     *
     * @param bid
     * @return
     */
    List<Comment> getAllByBid(Integer bid);

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
    List<Comment> getAllByCid(Integer cid);

    /**
     * 根据商家id和评价名称查询评价
     *
     * @param cid
     * @param name
     * @return
     */
    List<Comment> getAllByCidAndName(Integer cid, String name);


    /**
     * 查询一共多少条数据
     *
     * @param comment
     * @return
     */
    int getTotal(Comment comment);

    /**
     * 给id为某值的商家添加评价？
     *
     * @param comment
     * @return
     */
    int add(Comment comment);

    /**
     * 根据评价id更新
     *
     * @param comment
     * @return
     */
    int updateById(Comment comment);

    /**
     * 根据评价id删除
     *
     * @param id
     * @return
     */
    int deleteById(Integer id) throws Exception;

    /**
     * 根据评价id查询简单评价信息
     *
     * @param id
     * @return
     */
    Comment selectSimpleById(Integer id);

    /**
     * 根据评价id查询评价信息
     *
     * @param id
     * @return
     */
    Comment selectById(Integer id);


}
