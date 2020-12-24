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

    @Override
    public List<Comment> getAll() {
        try {
            return commentMapper.selectAll();
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
    public List<Comment> getAllByCid(String cid) {
        try {
            return commentMapper.getAllByCid(cid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Comment getOne(String cid, Integer pid) {
        try {
            return commentMapper.getOneByCidAndPid(cid, pid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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

    /**
     * 删除商品
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(Integer id) {
        // 先删除数据库中的对应商品
        int i = commentMapper.deleteByPrimaryKey(id);
        if (i < 1) {
            return -1;
        }
        return 1;
    }

    @Override
    public int update(Comment comment) {
        try {
            return commentMapper.updateByPrimaryKey(comment);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
