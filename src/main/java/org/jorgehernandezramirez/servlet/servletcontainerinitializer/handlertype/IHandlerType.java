package org.jorgehernandezramirez.servlet.servletcontainerinitializer.handlertype;

import javax.servlet.ServletContext;

/**
 * Api que va a proporcionar el método execute que deben definir las implementaciones
 * que van a ser inyectadas en nuestro ServletContainerInitializer
 */
public interface IHandlerType {
    /**
     * Método que se será llamado por nuestro ServletContainerInitializer sobre todas las
     * implementaciones que serán inyectadas
     */
    void execute(ServletContext servletContext);
}
