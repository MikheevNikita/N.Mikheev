package com.company;

public interface Stackable<T> {

    public T pop();

    public T peek();

    public void push(T element);

    public int size();

    public boolean isEmpty();
}
