package org.jorgehernandezramirez.servlet.servletcontainerinitializer.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SessionCreationFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionCreationFilter.class);

    public SessionCreationFilter(){
        super();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("Inicializando SessionCreationFilter");
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        LOGGER.info("SessionCreationFilter! -> Id sessión {}", getSessionId(request));
        chain.doFilter(request, response);
    }

    private String getSessionId(final ServletRequest request){
        return ((HttpServletRequest)request).getSession(true).getId();
    }

    @Override
    public void destroy() {
        LOGGER.info("Destruyendo SessionCreationFilter");
    }
}
