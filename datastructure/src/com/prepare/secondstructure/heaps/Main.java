package com.prepare.secondstructure.heaps;

public class Main {

    public static void main(String[] args) {

        CustomPQ pq = new CustomPQ();
        pq.insert(10);
        pq.insert(20);
        pq.insert(15);
        pq.insert(30);
        pq.insert(10);
        pq.insert(40);
        pq.insert(70);
        pq.insert(20);
        pq.insert(70);
        pq.insert(30);
        pq.insert(20);
        pq.insert(50);
        pq.insert(100);

        System.out.println(pq);

        pq.poll();
        System.out.println(pq);
        pq.poll();
        System.out.println(pq);


    }
}
