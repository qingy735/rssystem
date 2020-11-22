package cn.edu.henu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author Qing_Y
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    /**
     * 跳转到商家登陆页面
     *
     * @return
     */
    @RequestMapping("/business")
    public String toBusinessLoginPage(Model model, HttpSession session) {
        Integer registerCode = (Integer) session.getAttribute("tempId");
        // 若不为空肯定是大于0的
        if (registerCode != null) {
            model.addAttribute("tempId", session.getAttribute("tempId"));
            session.removeAttribute("tempId");
        }
        return "login&register/BuLogin";
    }

    /**
     * 跳转到顾客登陆页面
     *
     * @return
     */
    @RequestMapping("/consumer")
    public String toConsumerLoginPage() {
        return "login&register/StLogin";
    }

    /**
     * 跳转到管理员登陆页面
     *
     * @return
     */
    @RequestMapping("/admin")
    public String toAdminLoginPage() {
        return "login&register/AcLogin";
    }

    @RequestMapping("/checkCode")
    public void checkCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 服务器通知浏览器不要缓存
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("expires", "0");

        // 在内存中创建一个长80，宽30的图片，默认背景色为黑色
        int width = 80;
        int height = 30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 获取画笔
        Graphics graphics = image.getGraphics();
        // 画笔颜色为灰色
        graphics.setColor(Color.gray);
        // 填充图片背景色
        graphics.fillRect(0, 0, width, height);

        // 产生四个随机字符
        String checkCode = getCheckCode();
        // 将验证码存放在request中
        request.getSession().setAttribute("checkCode", checkCode);

        // 画笔颜色为黄色
        graphics.setColor(Color.yellow);
        // 设置字体大小
        graphics.setFont(new Font("黑体", Font.BOLD, 24));
        // 将验证码写入图片
        graphics.drawString(checkCode, 15, 25);

        // 将内存中的图片输出到浏览器中
        ImageIO.write(image, "JPEG", response.getOutputStream());
    }

    /**
     * 获得校验码
     *
     * @return
     */
    private String getCheckCode() {
        String base = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        int size = base.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            //产生0到size-1的随机值
            int index = r.nextInt(size);
            //在base字符串中获取下标为index的字符
            char ch = base.charAt(index);
            //将c放入到StringBuffer中去
            sb.append(ch);
        }

        return sb.toString();
    }


}
