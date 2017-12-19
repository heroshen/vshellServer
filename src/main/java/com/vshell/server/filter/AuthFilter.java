package com.vshell.server.filter;

import com.alibaba.fastjson.JSONObject;
import com.vshell.server.utils.MD5Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by heroshen on 2017/12/13.
 */
@Order(1)
@WebFilter(filterName = "authFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {
    @Value("${token}")
    private String token;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Map<String, String[]> treeMap = new TreeMap<>(servletRequest.getParameterMap());
        treeMap.remove("secret");
        String paramString = JSONObject.toJSONString(treeMap);
        String secret = servletRequest.getParameter("secret");
        if((secret!=null)&&(secret.equals(MD5Util.getMD5(paramString+token)))){
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            return;
        }
    }

    @Override
    public void destroy() {

    }
}
