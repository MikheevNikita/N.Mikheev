package com.company;

public interface Queable<T>{

    public T offer();

    public T peek();

    public void poll(T element) throws QueueOverloadException;

    public boolean isEmpty();

    public int size();
}
