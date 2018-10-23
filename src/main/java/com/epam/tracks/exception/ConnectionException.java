package com.epam.tracks.exception;

public class ConnectionException extends Exception {

    public ConnectionException(String message, Exception ex){
        super(message, ex);
    }
}
