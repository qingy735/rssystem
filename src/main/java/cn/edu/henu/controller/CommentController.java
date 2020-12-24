package cn.edu.henu.controller;

import cn.edu.henu.bean.Comment;
import cn.edu.henu.bean.Consumer;
import cn.edu.henu.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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
        Consumer loginInfo = (Consumer) session.getAttribute("conLoginInfo");
        Comment one = commentSer.getOne(loginInfo.getUsername(), comment.getPid());
        int i;
        if (one == null) {
            i = commentSer.add(comment);
        } else {
            one.setComment(comment.getComment());
            i = commentSer.update(one);
        }
        if (i < 1) {
            session.setAttribute("addPInfo", "插入失败");
            return "redirect:/pastOrder";
        }
        return "redirect:/assessment";
    }

    @RequestMapping("/delete")
    public String delete(Integer id, HttpSession session, @RequestHeader("REFERER") String referer) {
        int i = commentSer.deleteById(id);
        if (i < 1) {
            session.setAttribute("delInfo", "删除失败");
        }
        if (referer.contains("/admin")) {
            return "redirect:/admin/comments";
        } else {
            return "redirect:/assessment";
        }
    }

}
