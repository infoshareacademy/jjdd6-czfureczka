package com.infoshareacademy.jjdd6.czfureczka.filters;

import com.infoshareacademy.jjdd6.czfureczka.freemarker.TemplateProvider;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(
        filterName = "MenuFilter",
        urlPatterns = {"/menu"}
//        initParams = {
//        @WebInitParam(name = "", value = )
//}
        )

public class MenuFilter implements Filter {

    String intialStop = "initalStop";


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletRequest.setAttribute();
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
