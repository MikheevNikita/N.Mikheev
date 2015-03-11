package com.company;
import java.util.ArrayList;

public class Array {
    ArrayList<Object> arr;

    void Array(){
        arr = new ArrayList<Object>();
    }

    void addElement(Object object){
        arr.add(object);
        arr.ensureCapacity(arr.size() + 5 - arr.size()%5);
    }

    void insertElement(int index, Object object){
        arr.add(index, object);
        arr.ensureCapacity(arr.size() + 5 - arr.size()%5);
    }

    void removeElement(Object object){
        arr.remove(object);
        arr.ensureCapacity(arr.size() + 5 - arr.size()%5);
    }

    Object getElement(int index){
        return arr.get(index);
    }

    int getSize(){
        return arr.size();
    }
}
