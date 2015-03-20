package com.company;

public class Item<T> {

    private T item;
    private Item<T> associated;


    public T getItem() {
        return item;
    }

    void setItem(T item){
        this.item = item;
    }

    void setNext(Item<T> item){
        associated = item;
    }

    public Item<T> getAssociated(){
        return associated;
    }

    boolean hasNext(){
        if (associated != null){
            return true;
        }else{
            return false;
        }
    }


}
