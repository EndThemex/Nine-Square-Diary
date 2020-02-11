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

import com.endtheme.ninesquarediary.AppContext;
import com.endtheme.ninesquarediary.model.User;

public class AppContextFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

    @Override
    public void doFilter(ServletRequest httpRequest, ServletResponse httpResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)httpRequest;
        HttpServletResponse response = (HttpServletResponse)httpResponse;
        HttpSession session = request.getSession();
        // 将登录用户信息存入
        User user = (User) session.getAttribute("user");
        AppContext.setContextPath(request.getContextPath());
        String path = request.getSession().getServletContext().getRealPath("/");// 获得项目真实路径
        
        AppContext appContext = AppContext.getAppContext();
        appContext.addObjects("user", user);
        appContext.addObjects("path", path);
        appContext.addObjects("session", session);
        appContext.addObjects("request", request);
        appContext.addObjects("response", response);

        try {
            chain.doFilter(request, response);
        } finally {
            appContext.clear();
        }
    }

	@Override
    public void destroy() {
    	Filter.super.destroy();
    }
}
