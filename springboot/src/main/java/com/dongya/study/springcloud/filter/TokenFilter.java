package com.dongya.study.springcloud.filter;

import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TokenFilter implements Filter {
    protected static List<String> notFilterUrl = new ArrayList<>();
    private static final String ERROR_TOKEN = "/error_token";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        notFilterUrl.add("/error");
        notFilterUrl.add("/login");
        System.out.println("token拦截器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        System.out.println("this is TokenFilter,url:" + uri);
        boolean notFilter = false;
        for(String url:notFilterUrl){
            if(uri.contains(url)){
                notFilter = true;
                break;
            }
        }
        if(notFilter){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        String cuserId = request.getParameter("cuserId");
        if(StringUtils.isEmpty(cuserId)){
            response.sendRedirect(ERROR_TOKEN);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("token拦截器被销毁");
    }
}
