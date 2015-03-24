package com.company;

public class QueueOverloadException extends Exception {

    public void message(){
        System.err.print("Failed to add a student to the queue: queue cannot be appended");
    }
}
