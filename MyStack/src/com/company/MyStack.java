package com.company;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyStack<T> implements Stackable<T>, Iterable<T>{

    private Object[] elements = new Object[0];

    @Override
    public T pop(){
        T pop = (T) elements[size()-1];
        Object[] temp = new Object[size()-1];
        for(int index = 0; index < size()-1; index++){
            temp[index] = elements[index];
        }
        elements = new Object[size()-1];
        for (int index = 0; index < size(); index++){
            elements[index] = temp[index];
        }
        return pop;
    }

    @Override
    public T peek(){
        if (size() != 0) {
            return (T) elements[size() - 1];
        }else{
            return null;
        }
    }

    @Override
    public void push(T element) {
        int newSize = size() + 1;
        Object[] temp = new Object[size()];
        for(int index = 0; index < size(); index++){
            temp[index] = elements[index];
        }
        this.elements = new Object[newSize];
        for (int index = 0; index < size()-1; index++){
            elements[index] = temp[index];
        }
        elements[newSize - 1] = element;
    }

    @Override
    public int size(){
        return elements.length;
    }


    @Override
    public boolean isEmpty() {
        if (size() == 0){
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
