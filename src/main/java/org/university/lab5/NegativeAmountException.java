package org.university.lab5;

public class NegativeAmountException extends RuntimeException{
    public NegativeAmountException(String message){
        super(message);
    }
}
