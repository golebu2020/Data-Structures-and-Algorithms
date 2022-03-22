package com.prepare.secondstructure.graph2;

import java.util.*;

public class HasPathUndirected {
   
    /*
    Write a function, undirectedPath, that takes in an array of edges for an undirected graph
    and two nodes (nodeA, nodeB). The function should return a boolean indicating whethere or not
    these exists a path between nodeA and nodeB
    test_00:
    const edges = [
        ['i','j'],
        ['k','i'],
        ['m','k'],
        ['k','l'],
        ['o','n']
    ];

    undirectedPath (edges, 'j','m'); //t --> true
     */
    /*
    This was implemented using an Queue/BreadthFirst Approach
    */

    public static void main(String[] args){
        HashMap<Character, ArrayList<Character>> graph = new HashMap<>();
        buildGraph(graph, 'i',new Character[]{'j', 'k'});
        buildGraph(graph, 'j',new Character[]{'i'});
        buildGraph(graph, 'k',new Character[]{'i','m','l'});
        buildGraph(graph, 'm',new Character[]{'k'});
        buildGraph(graph, 'l',new Character[]{'k'});
        buildGraph(graph, 'o',new Character[]{'n'});
        buildGraph(graph, 'n',new Character[]{'o'});
        System.out.println(graph);
        System.out.println(undirectedPath(graph, 'i','m'));
    }

    private static void buildGraph(HashMap<Character, ArrayList<Character>> graph, Character key, Character[] values){
        ArrayList<Character> characters = new ArrayList<>();
        characters.addAll(Arrays.asList(values));
        graph.put(key, characters);
    }

    //implementing using a breadth first approach

    private static boolean undirectedPath(HashMap<Character, ArrayList<Character>> graph, Character nodeA, Character nodeB){
        Queue<Character> queue = new LinkedList<>();
        ArrayList<Character> visited = new ArrayList<>();
        queue.offer(nodeA);
        while(queue.size() > 0){
            var current  = queue.poll();
            if(current.equals(nodeB)) return true;
            if(!(visited.contains(current))) visited.add(current);
            for(Character neighbour: graph.get(current)){
                if(!(visited.contains(neighbour))){
                    queue.offer(neighbour);
                    visited.add(neighbour);
                }
            }
        }
        return false;
    }

}
