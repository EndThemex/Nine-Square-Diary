package com.endtheme.ninesquarediary.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class PageEncodingFilter implements Filter {
	
    private String enconding = "UTF-8";
    protected FilterConfig filterConfig;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        request.setCharacterEncoding(enconding);
        chain.doFilter(request, servletResponse);
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

        this.filterConfig = fConfig;
        if (filterConfig.getInitParameter("enconding") != null) {
            enconding = filterConfig.getInitParameter("enconding");
        }
    }
    
    @Override
    public void destroy() {
    	Filter.super.destroy();
    }

}
