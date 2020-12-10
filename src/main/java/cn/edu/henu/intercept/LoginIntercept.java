package cn.edu.henu.intercept;

import cn.edu.henu.bean.Business;
import cn.edu.henu.bean.Consumer;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录验证拦截器：
 * 判断访问某特定页面时是否有登录信息
 * 有：直接跳转
 * 没有：跳转到登陆页面
 *
 * @author Qing_Y
 */
public class LoginIntercept implements HandlerInterceptor {

    private final String LOGIN_MSG = "login";
    private final String REGISTER_MSG = "register";

    /**
     * 预处理方法，controller方法执行之前
     * return true：放行
     * return false：不放行
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();

        Business business = (Business) request.getSession().getAttribute("busLoginInfo");
        Consumer consumer = (Consumer) request.getSession().getAttribute("conLoginInfo");

        if (uri.contains(LOGIN_MSG) || uri.contains(REGISTER_MSG)) {
            return true;
        }

        // 访问商家后台
        if (uri.contains("/business")) {
            if (business == null) {
                // 没有登陆信息
                request.setAttribute("bus_login_msg", "请先登录");
                request.getRequestDispatcher("/WEB-INF/pages/login&register/first.jsp").forward(request, response);
                return false;
            }
        }

        if (uri.contains("/consumer")) {
            if (consumer == null) {
                // 没有登陆信息
                request.setAttribute("con_login_msg", "请先登录");
                request.getRequestDispatcher("/WEB-INF/pages/login&register/first.jsp").forward(request, response);
                return false;
            }
        }
        return true;
    }

    /**
     * 后处理方法，controller方法执行后，跳转页面执行前
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 跳转页面执行后执行
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
