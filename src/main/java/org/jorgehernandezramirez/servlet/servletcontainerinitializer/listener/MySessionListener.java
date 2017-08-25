package org.jorgehernandezramirez.servlet.servletcontainerinitializer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MySessionListener.class);

    public MySessionListener(){
        super();
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        LOGGER.info("Creando la sesión -> {}", httpSessionEvent.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        LOGGER.info("Destruyendo la sesión -> {}", httpSessionEvent.getSession().getId());
    }
}
