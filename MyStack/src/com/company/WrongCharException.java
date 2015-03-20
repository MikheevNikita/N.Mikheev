package com.company;

/**
 * Created by Nikita_Mikheev on 15-03-17.
 */
public class WrongCharException extends Exception {
    public void message(){
        System.err.print("Bracket could not be reconized");
    }

}
