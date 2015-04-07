package com.company;

// Created by N.Mikheev. Class which has functionality of a 2-3 Map and may be used as it.

public class TwoThreeTree<T extends Comparable>{

    private T firstNode;
    private T secondNode;
    private TwoThreeTree<T> parent;
    private TwoThreeTree<T> left;
    private TwoThreeTree<T> middle;
    private TwoThreeTree<T> right;
    private boolean isParent;

    public TwoThreeTree(T node, TwoThreeTree<T> parent){
        firstNode = node;
        this.parent = parent;
        parent.isParent = true;
    }

    public void insert(T node) {
        if (firstNode.compareTo(node) < 0) {
            if (secondNode == null){
                addNode(right, node);
            } else {
                if (secondNode.compareTo(node) > 0){
                    addNode(middle, node);
                }else{
                    addNode(right, node);
                }
            }
        } else {
                addNode(left, node);
        }
    }


    private void addNode(TwoThreeTree<T> tree, T node){
        if (tree == null) {
            tree = new TwoThreeTree<T>(node, this);
        } else if (!tree.isParent && tree.secondNode == null) {
            if (tree.firstNode.compareTo(node) < 0) {
                tree.secondNode = node;
            } else {
                tree.secondNode = tree.firstNode;
                tree.firstNode = node;
            }
        } else if (!tree.isParent) {
            refactor(tree, node);
        } else {
            tree.insert(node);
        }
    }
    private void refactor(TwoThreeTree<T> tree,T node){
        if (tree.isParent){
            if (tree.firstNode.compareTo(node) > 0){
                TwoThreeTree newRoot = new TwoThreeTree<T>(tree.firstNode, null);
                newRoot.left = new TwoThreeTree<T>(node, newRoot);
                newRoot.right = new TwoThreeTree<T>(tree.secondNode, newRoot);
                tree.left.parent = newRoot.left;
                tree.right.parent = newRoot.right;
                tree.middle.parent = newRoot;
            } else if (tree.secondNode.compareTo(node) < 0){
                TwoThreeTree newRoot = new TwoThreeTree<T>(tree.secondNode, null);
                newRoot.right = new TwoThreeTree<T>(node, newRoot);
                newRoot.left = new TwoThreeTree<T>(node, newRoot);
                tree.left.parent = newRoot.left;
                tree.right.parent = newRoot.right;
                tree.middle.parent = newRoot;
            }
        }
        //I'm done, I give up
    }

}
