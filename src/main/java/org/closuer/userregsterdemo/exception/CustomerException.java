package org.closuer.userregsterdemo.exception;

public class CustomerException extends RuntimeException{
    public CustomerException (String error){
        super(error);
    }
}
