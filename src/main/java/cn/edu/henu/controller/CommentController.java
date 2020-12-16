package cn.edu.henu.controller;

import cn.edu.henu.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String add() {
        commentSer.add(null);
        return "success";
    }

    @RequestMapping("/delete")
    public String delete() {
        commentSer.delete(-1);
        return "success";
    }

    @RequestMapping("/findByPid")
    public String selectByPid() {
        commentSer.selectByPid(-1);
        return "success";
    }

    @RequestMapping("/findByCid")
    public String selectByCid() {
        commentSer.selectByCid("");
        return "success";
    }
}
