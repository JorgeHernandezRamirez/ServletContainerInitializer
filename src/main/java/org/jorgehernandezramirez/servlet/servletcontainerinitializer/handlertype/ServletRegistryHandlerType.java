package org.jorgehernandezramirez.servlet.servletcontainerinitializer.handlertype;

import org.jorgehernandezramirez.servlet.servletcontainerinitializer.MyServletContainerInitializer;
import org.jorgehernandezramirez.servlet.servletcontainerinitializer.servlet.MyServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class ServletRegistryHandlerType implements IHandlerType {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServletRegistryHandlerType.class);

    private static final String SERVLET_NAME = "myservlet";

    private static final String SERVLET_CONTEXT_PATH = "/myservlet";

    public ServletRegistryHandlerType(){
        super();
    }

    @Override
    public void execute(final ServletContext servletContext) {
        LOGGER.info("Registrando servlets de nuestra app");
        final ServletRegistration.Dynamic registration = servletContext.addServlet(SERVLET_NAME, MyServlet.class);
        registration.setLoadOnStartup(1);
        registration.addMapping(new String[]{SERVLET_CONTEXT_PATH});
        registration.setAsyncSupported(true);
    }
}
