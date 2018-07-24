package com.seoi.web.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author shuaiqi
 * @create 2018-07-24 16:49
 * @desc 时间拦截器
 **/
public class TimeInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse, final Object handler) throws Exception {
        System.out.println("preHandle");

        System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
        System.out.println(((HandlerMethod)handler).getMethod().getName());

        httpServletRequest.setAttribute("startTime", new Date().getTime());
        return true;
    }

    @Override
    public void postHandle(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse, final Object handler, final ModelAndView modelAndView) throws Exception {
        System.out.println("postHandler");
        final Long startTime = (Long)httpServletRequest.getAttribute("startTime");
        System.out.println("time interceptor 耗时:" + (new Date().getTime() - startTime));
    }

    @Override
    public void afterCompletion(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse, final Object handler, final Exception e) throws Exception {
        System.out.println("afterCompletion");
        final Long startTime = (Long) httpServletRequest.getAttribute("startTime");
        System.out.println("time interceptor 耗时:" + (new Date().getTime() - startTime));
        System.out.println("ex is" + e);
    }
}
