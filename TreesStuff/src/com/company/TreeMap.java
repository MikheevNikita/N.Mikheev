package com.company;

public class TreeMap<T extends Comparable>{

    T node;
    TreeMap<T> left;
    TreeMap<T> right;

    public TreeMap(T node){
        this.node = node;
    }

    public void insert(T nextNode){
       if (node.compareTo(nextNode) > 0){
           if (left == null){
               left = new TreeMap<T>(nextNode);
           }else{
               left.insert(nextNode);
           }
       } else if (node.compareTo(nextNode) < 0) {
           if (right == null) {
               right = new TreeMap<T>(nextNode);
           }else{
               right.insert(nextNode);
           }
       }
    }

    public T getNode(){
        return node;
    }
}
