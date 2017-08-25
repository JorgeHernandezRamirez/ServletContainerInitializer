package org.jorgehernandezramirez.servlet.servletcontainerinitializer.handlertype;

import org.jorgehernandezramirez.servlet.servletcontainerinitializer.MyServletContainerInitializer;
import org.jorgehernandezramirez.servlet.servletcontainerinitializer.listener.MySessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;

public class ListenerRegistryHandlerType implements IHandlerType {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyServletContainerInitializer.class);

    public ListenerRegistryHandlerType(){
        super();
    }

    @Override
    public void execute(final ServletContext servletContext) {
        LOGGER.info("Registrando listeners en nuestra app");
        servletContext.addListener(MySessionListener.class);
    }
}
