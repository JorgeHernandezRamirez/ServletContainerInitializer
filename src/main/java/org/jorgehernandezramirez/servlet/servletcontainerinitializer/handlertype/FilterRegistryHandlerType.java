package org.jorgehernandezramirez.servlet.servletcontainerinitializer.handlertype;

import org.jorgehernandezramirez.servlet.servletcontainerinitializer.MyServletContainerInitializer;
import org.jorgehernandezramirez.servlet.servletcontainerinitializer.filter.SessionCreationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

public class FilterRegistryHandlerType implements IHandlerType {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyServletContainerInitializer.class);

    private static final String FILTER_NAME = "myfilter";

    private static final String FILTER_CONTEXT_PATH = "/*";

    public FilterRegistryHandlerType(){
        super();
    }

    @Override
    public void execute(final ServletContext servletContext) {
        LOGGER.info("Registrando filtros en nuestra app");
        final FilterRegistration.Dynamic registration = servletContext.addFilter(FILTER_NAME, SessionCreationFilter.class);
        registration.setAsyncSupported(true);
        registration.addMappingForUrlPatterns(null , true, FILTER_CONTEXT_PATH);
    }
}
