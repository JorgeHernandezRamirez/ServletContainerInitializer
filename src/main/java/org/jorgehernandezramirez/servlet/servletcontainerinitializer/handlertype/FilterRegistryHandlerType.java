package org.jorgehernandezramirez.servlet.servletcontainerinitializer.handlertype;

import org.jorgehernandezramirez.servlet.servletcontainerinitializer.MyServletContainerInitializer;
import org.jorgehernandezramirez.servlet.servletcontainerinitializer.filter.ErrorPageFilter;
import org.jorgehernandezramirez.servlet.servletcontainerinitializer.filter.SessionCreationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

public class FilterRegistryHandlerType implements IHandlerType {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyServletContainerInitializer.class);

    private static final String FILTER_NAME_ERROR_PAGE = "myfilterErrorPage";

    private static final String FILTER_NAME_SESSION_CREATED = "myfilterSessionCreated";

    private static final String FILTER_CONTEXT_PATH = "/*";

    public FilterRegistryHandlerType(){
        super();
    }

    @Override
    public void execute(final ServletContext servletContext) {
        LOGGER.info("Registrando filtros en nuestra app");
        final FilterRegistration.Dynamic registrationErrorPageFilter = servletContext.addFilter(FILTER_NAME_ERROR_PAGE, ErrorPageFilter.class);
        registrationErrorPageFilter.setAsyncSupported(true);
        registrationErrorPageFilter.addMappingForUrlPatterns(null , true, FILTER_CONTEXT_PATH);
        final FilterRegistration.Dynamic registrationSessionCreatedFilter = servletContext.addFilter(FILTER_NAME_SESSION_CREATED, SessionCreationFilter.class);
        registrationSessionCreatedFilter.setAsyncSupported(true);
        registrationSessionCreatedFilter.addMappingForUrlPatterns(null , true, FILTER_CONTEXT_PATH);
    }
}
