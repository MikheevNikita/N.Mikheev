package com.company;

public class TreeMap<T extends Comparable>{

    private T node;
    private TreeMap<T> left;
    private TreeMap<T> right;

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
    public void remove(T node){
        if (this.node != node){
            if (this.node.compareTo(node) > 0){
                left.remove(node);
            }else{
                right.remove(node);
            }
        }else{
            this.node = findNewNode();
        }
    }
    private T findNewNode(){
        if (left.getLeft() != null){
            left.findNewNode();
        }
        T temp = getRight().getNode();
        if (right.getLeft() == null && right.getRight() == null){
            right.node = null;
        }else{
            right.node = node;
        }
        return temp;
    }

    public T getNode(){
        return node;
    }
    public TreeMap<T> getLeft(){return left;}
    public TreeMap<T> getRight(){return right;}
}
