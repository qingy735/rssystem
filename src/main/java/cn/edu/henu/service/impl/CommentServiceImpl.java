package cn.edu.henu.service.impl;

import cn.edu.henu.bean.Comment;
import cn.edu.henu.dao.CommentMapper;
import cn.edu.henu.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int add(Comment comment) {
        try {
            return commentMapper.insert(comment);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(Integer id) {
        try {
            return commentMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<Comment> selectByPid(Integer pid) {
        try {
            return commentMapper.selectByPid(pid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Comment> selectByCid(String cid) {
        try {
            return commentMapper.selectByCid(cid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
