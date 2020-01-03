package com.endtheme.ninesquarediary.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
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
    public void doFilter(ServletRequest httpRequest, ServletResponse httpResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)httpRequest;
        HttpServletResponse response = (HttpServletResponse)httpResponse;
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        AppContext.setContextPath(request.getContextPath());

        AppContext appContext = AppContext.getAppContext();
        appContext.addObjects("user", user);
        appContext.addObjects("session", session);

        try {
            chain.doFilter(request, response);
        } finally {
            appContext.clear();
        }
    }

}
