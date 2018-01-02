package org.jorgehernandezramirez.servlet.servletcontainerinitializer.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

public class ErrorPageHttpServletResponseWrapper extends HttpServletResponseWrapper {

    private static final String ERROR_PAGE = "404.html";

    public ErrorPageHttpServletResponseWrapper(HttpServletRequest request, HttpServletResponse response) {
        super(response);
    }

    @Override
    public void sendError(int sc) throws IOException {
        if(sc == 404) {
            ((HttpServletResponse) getResponse()).sendRedirect(ERROR_PAGE);
        }
    }

    @Override
    public void sendError(int sc, String msg) throws IOException {
        sendError(sc);
    }
}