package com.company;

public class WrongInitializingException extends Exception {
    public void message(){
        System.err.print("Provided initializers could not be processed");
    }
}
