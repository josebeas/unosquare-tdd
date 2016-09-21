package com.sanbeso.webapp.exception;

/**
 * Method under development process exception
 *
 * @author Jose Beas
 * @version 1.0
 */
public class MethodNotImplemented extends Exception {


    /**
     * Custom constructor to let user know when a method is on development
     *
     * @param className
     */
    public MethodNotImplemented(String className){
        super("Method on class " + className + " is under development, get this exception on development process is ok, if not please report it to a developer");
    }

}
