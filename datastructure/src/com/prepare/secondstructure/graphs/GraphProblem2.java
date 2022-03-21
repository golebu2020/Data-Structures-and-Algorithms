package com.prepare.secondstructure.graphs;

import java.util.*;

public class GraphProblem2 {
     /* Write a function, hasPath,that takes in an object representing the adjacent list of a directed acyclic graph
    and two nodes (src,dsc). The function should return a boolean indicating whether or  not there exists a directed
    path between the source and destination nodes
    test01:
    const: graph = {
      f: ['g', 'i'],
      g: ['h'],
      h: [],
      i: ['g','k'],
      j: ['i'],
      k : []
    }
    hasPath(graph, 'f','k')-
     */

    //using the Breadth First Approach
    private static final Queue<Character> queue= new LinkedList<>();
    private static final Hashtable<Character, ArrayList<Character>> graph = new Hashtable<>();

    public static void main(String[] args) {
        ArrayList<Character> f = new ArrayList<>();f.add('g'); f.add('i');
        ArrayList<Character> g = new ArrayList<>();g.add('h');
        ArrayList<Character> h = new ArrayList<>();
        ArrayList<Character> i = new ArrayList<>();i.add('g'); i.add('k');
        ArrayList<Character> j = new ArrayList<>();j.add('i');
        ArrayList<Character> k = new ArrayList<>();

        graph.put('f',f);
        graph.put('g',g);
        graph.put('h',h);
        graph.put('i',i);
        graph.put('j',j);
        graph.put('k',k);

        System.out.println(hasPath(graph, 'i','g'));

    }

    public static boolean hasPath(Hashtable<Character, ArrayList<Character>> graph, Character src, Character dst){
        queue.offer(src);
        while(queue.size() > 0){
            var current = queue.poll();
            if(graph.get(current).contains(dst)) return true;
            for (Character neighbour : graph.get(current)) {
                queue.offer(neighbour);
            }

        }
        return false;
    }
}
