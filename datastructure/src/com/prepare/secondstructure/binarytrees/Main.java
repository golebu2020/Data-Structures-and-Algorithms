package com.prepare.secondstructure.binarytrees;

public class Main {
    public static void main(String[] args) {
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');
        Node g= new Node('g');

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setLeft(f);
        c.setRight(g);


        System.out.println(a.getRight().getData());
        System.out.println(c.getRight().getData());


        //                 a
        //               /  \
        //              b    c
        //            /  \  / \
        //           d    e f  g
        //         / \   /\ /\ /\
        //

        //




    }
}
