package com.epam.tracks.exception;

public class CommandException extends Exception {

    public CommandException(String message, Exception ex){
        super(message, ex);
    }

    public CommandException(String message){
        super(message);
    }

    public CommandException(Exception ex){
        super(ex);
    }

    public CommandException(){

    }
}
