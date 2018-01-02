package org.jorgehernandezramirez.servlet.servletcontainerinitializer.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorPageFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionCreationFilter.class);

    public ErrorPageFilter(){
        super();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("Inicializando ErrorPageFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, new ErrorPageHttpServletResponseWrapper((HttpServletRequest) request, (HttpServletResponse) response));
    }
}
