package com.epam.tracks.exception;

public class ServiceException extends Exception {

    public ServiceException(Exception ex){
        super(ex);
    }

    public ServiceException(){

    }
}
