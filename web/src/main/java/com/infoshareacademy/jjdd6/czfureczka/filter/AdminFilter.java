package com.infoshareacademy.jjdd6.czfureczka.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(
        filterName = "AuthenticationFilter",
        urlPatterns = {"/admin"})
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (servletRequest.getParameter("email") != null && !servletRequest.getParameter("email").isEmpty()){
            Pattern valid = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
            String email = servletRequest.getParameter("email");
            Matcher matcher = valid.matcher(email);
            if (matcher.find()){
                servletRequest.setAttribute("email", "good");
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
