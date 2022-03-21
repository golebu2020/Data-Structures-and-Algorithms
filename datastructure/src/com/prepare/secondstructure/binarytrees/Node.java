package com.prepare.secondstructure.binarytrees;

public class Node {
    private char data;
    private Node left;
    private Node right;

    public Node(char data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public char getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setData(char data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
