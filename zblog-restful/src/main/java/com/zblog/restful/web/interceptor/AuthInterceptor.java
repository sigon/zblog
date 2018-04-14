package com.zblog.restful.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author bjyfshiguang
 * @project zblog-restful
 * @since 2018/4/12 14:46
 */
public class AuthInterceptor extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //验证用户登录状态
        return true;
    }
}
