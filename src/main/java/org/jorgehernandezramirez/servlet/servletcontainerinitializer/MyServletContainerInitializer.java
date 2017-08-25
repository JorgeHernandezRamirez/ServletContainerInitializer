package org.jorgehernandezramirez.servlet.servletcontainerinitializer;

import org.jorgehernandezramirez.servlet.servletcontainerinitializer.handlertype.IHandlerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

@HandlesTypes({IHandlerType.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyServletContainerInitializer.class);

    public MyServletContainerInitializer(){
        super();
    }

    @Override
    public void onStartup(final Set<Class<?>> handlerTypeSet, final ServletContext servletContext) throws ServletException {
        callImplementationHandlerType(handlerTypeSet, servletContext);
    }

    private void callImplementationHandlerType(final Set<Class<?>> handlerTypeSet, final ServletContext servletContext){
        if(handlerTypeSet != null){
            handlerTypeSet.forEach(aClass -> {
                executeImplementationIHandlerTypeInstance(aClass, servletContext);
            });
        }
    }

    private void executeImplementationIHandlerTypeInstance(Class<? extends Object> handlerTypeClass, final ServletContext servletContext){
        try {
            final IHandlerType handlerType = (IHandlerType) handlerTypeClass.newInstance();
            handlerType.execute(servletContext);
        }
        catch(Throwable throwable){
            LOGGER.error("Ha ocurrido un error al execute una implementación de IHandlerType", throwable);
            throw new RuntimeException(throwable);
        }
    }
}
