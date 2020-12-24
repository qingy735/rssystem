package cn.edu.henu.service.impl;

import cn.edu.henu.bean.Comment;
import cn.edu.henu.bean.PageBean;
import cn.edu.henu.bean.Comment;
import cn.edu.henu.dao.CommentMapper;
import cn.edu.henu.dao.CommentMapper;
import cn.edu.henu.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-12-16 13:39
 */
@Service("commentSer")
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    void initPageBean(PageBean<Comment> pageBean, Comment comment, Integer row) {
        pageBean.setRows(row);
        int total = getTotal(comment);
        pageBean.setTotalCount(total);
        int rows = pageBean.getRows();
        int a = total % rows;
        int b = total / rows;
        pageBean.setTotalPage(a == 0 ? b : b + 1);
    }

    @Override
    public PageBean<Comment> getAllComments(Comment comment, Integer row) {
        try {
            List<Comment> comments;
            if (comment != null) {
                comments = commentMapper.selectByCondition(comment);
            } else {
                comments = commentMapper.selectAll();
            }
            PageBean<Comment> pageBean = new PageBean<>();
            initPageBean(pageBean, comment, row);
            pageBean.setList(comments);
            return pageBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Comment> getAllByBid(Integer bid) {
        try {
            return commentMapper.getAllByBid(bid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<Comment> getAllByPid(Integer pid) {
        try {
            return commentMapper.getAllByPid(pid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Comment> getAllByCid(Integer cid) {
        try {
            return commentMapper.getAllByPid(cid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 @Override
    public List<Comment> getAllByCidAndName(Integer cid, String name) {
        try {
            return commentMapper.getAllByCidAndName(cid, name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getTotal(Comment comment) {
        try {
            return commentMapper.selectTotal(comment);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int add(Comment comment) {
        try {
            return commentMapper.insert(comment);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int updateById(Comment comment) {
        if (comment.getId() == null) {
            return -1;
        }
        if ("".equals(comment.getGrade())) {
            comment.setGrade(null);
        }
        if ("".equals(comment.getComment())) {
            comment.setComment(null);
        }
        try {
            return commentMapper.updateByPrimaryKey(comment);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 删除商品
     *
     * @param id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteById(Integer id) throws Exception {
        // 先删除数据库中的对应商品
        int i = commentMapper.deleteByPrimaryKey(id);
        if (i < 1) {
            throw new Exception();
        }
        return 1;
    }

    @Override
    public Comment selectSimpleById(Integer id) {
        try {
            return commentMapper.selectSimpleById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Comment selectById(Integer id) {
        try {
            return commentMapper.selectById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
