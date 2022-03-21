package com.prepare.secondstructure.graphs;

import java.lang.reflect.Array;
import java.util.*;

public class GraphProblem3 {
    /*Write a function, undirectedPath, that takes in an array of edges for an undirected
    graph and two nodes (nodeA, nodeB). The function should return a boolean indicating whether
    or not there exists a path between nodeA and nodeB
    edges: [
       [i,j],
       [k,i],
       [m,k],
       [k,l],
       [o,n]
    ]
    {i=[j, k], j=[i], k=[l, i, m], l=[k], m=[k], n=[o], o=[n]}
     */
    private static ArrayList<Character> visited = new ArrayList<>();
    private static Queue<Character> queue = new LinkedList<>();
    public static void main(String[] args) {
        Hashtable<Character, ArrayList<Character>> edges = new Hashtable<>();
        buildEdges(edges,'i', new Character[]{'j','k'});
        buildEdges(edges,'k', new Character[]{'l','i','m'});
        buildEdges(edges,'j', new Character[]{'i'});
        buildEdges(edges,'n', new Character[]{'o'});
        buildEdges(edges,'o', new Character[]{'n'});
        buildEdges(edges,'l', new Character[]{'k'});
        buildEdges(edges,'m', new Character[]{'k'});

        System.out.println(undirectPath(edges, 'i','k'));
    }

   private static boolean undirectPath(Hashtable<Character, ArrayList<Character>> edges, Character nodeA, Character nodeB){
        queue.offer(nodeA);
        while(!(queue.isEmpty())){
            var current = queue.poll();
            if(current.equals(nodeB)) return true;
            ArrayList<Character> neigbhours = edges.get(current);
            for (Character neigbhour : neigbhours ) {
                if(!(visited.contains(neigbhour))){
                    visited.add(neigbhour);
                    queue.offer(neigbhour);
                }
            }
        }
        return false;
   }

    private static void buildEdges(Hashtable<Character, ArrayList<Character>> edges, Character key, Character[] values){
        ArrayList<Character> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(values));
        edges.put(key, arr);
    }
}
