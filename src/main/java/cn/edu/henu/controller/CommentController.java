package cn.edu.henu.controller;

import cn.edu.henu.bean.Comment;
import cn.edu.henu.service.ICommentService;
import cn.edu.henu.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Qing_Y
 * @date 2020-12-16 13:43
 */
@Controller
@RequestMapping("/comment")
public class CommentController {


    @Autowired
    private ICommentService commentSer;

    @RequestMapping("/add")
    public String add(Comment comment, HttpSession session) {
        try {
            int i = commentSer.add(comment);
            if (i < 1) {
                session.setAttribute("addPInfo", "插入失败");
                return "redirect:/uploadComments";
            }
            return "redirect:/commentList";
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("addPInfo", "插入失败");
            return "redirect:/uploadComments";
        }
    }

    @RequestMapping("/delete")
    public String delete(Integer id, HttpSession session) {
        Comment comment = commentSer.selectSimpleById(id);
        int i = 0;
        try {
            i = commentSer.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("delInfo", "删除失败");
        }
        return "redirect:/commentList";
    }

    @RequestMapping("/update")
    public String update(Comment comment, HttpSession session) {
        Object updateInfo = session.getAttribute("updateInfo");
        if (updateInfo != null) {
            session.removeAttribute("updateInfo");
        }
            int i = commentSer.updateById(comment);
            if (i < 1) {
                session.setAttribute("updateInfo", "更新失败");
                return "redirect:/updateComments";
            }
            return "redirect:/commentList";
    }

}
