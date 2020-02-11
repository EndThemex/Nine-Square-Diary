package com.endtheme.ninesquarediary.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.endtheme.ninesquarediary.DiaryConstants;
import com.endtheme.ninesquarediary.model.User;
import com.endtheme.ninesquarediary.util.PathUtil;

public class SessionFilter implements Filter {

    private String noNeedLogin = ""; // Pages can access without logging in, will be loaded from XML
    protected FilterConfig filterConfig;

    @Override
    public void destroy() {
    	Filter.super.destroy();
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    	this.filterConfig = fConfig;
    	if (filterConfig.getInitParameter("noNeedLoginPages") != null) {
    		noNeedLogin = filterConfig.getInitParameter("noNeedLoginPages");
    	}
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        HttpSession session =  httpRequest.getSession();

        String uri = httpRequest.getRequestURI();
        String requestUri = uri.substring(httpRequest.getContextPath().length() + 1);
        String [] pages = noNeedLogin.split(DiaryConstants.COMMA_SIGN);
        boolean isAllow = false;

        for (String page : pages) {
            if (page.equals(requestUri)) {
                isAllow = true;
                break;
            }
        }
        // Logout action
        if ("page/user/logout".equals(requestUri)) {
            session.setAttribute("user", null);
        }

        User user = (User)session.getAttribute("user");
        // 是否为放行请求
        if (isAllow) {
            if ("page/user/login".equals(requestUri) && user != null) {
                httpResponse.sendRedirect(PathUtil.getFullPath("user/welcome"));
            }
            chain.doFilter(httpRequest, httpResponse);
        } else {
            if (user == null) {
                if (httpRequest.getMethod().toUpperCase().equals("GET") && !"page/user/logout".equals(requestUri)) {
                    httpResponse.sendRedirect(PathUtil.getFullPath("user/login") + "?" + "go=" + requestUri);
                } else {
                    httpResponse.sendRedirect(PathUtil.getFullPath("user/welcome"));
                }
            } else {
                chain.doFilter(httpRequest, httpResponse);
            }
        }
    }

}
