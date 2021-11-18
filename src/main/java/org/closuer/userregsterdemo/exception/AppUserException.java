package org.closuer.userregsterdemo.exception;

public class AppUserException extends RuntimeException{
    public AppUserException (String error){
        super(error);
    }
}
