package com.prepare.secondstructure.graph2;

import java.util.*;

public class connectedComponents {
    /*
    Write a function, connectedComponentsCount, that takes in the adjacency list of
    an undirected graph. The function should return the number of connected components
    within the graph
     */
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        buildGraph(graph, 1, new Integer[]{2});
        buildGraph(graph, 2, new Integer[]{1});
        buildGraph(graph, 4, new Integer[]{6});
        buildGraph(graph, 5, new Integer[]{6});
        buildGraph(graph, 8, new Integer[]{6});
        buildGraph(graph, 7, new Integer[]{6});
        buildGraph(graph, 6, new Integer[]{4, 8, 5, 7});
        buildGraph(graph, 3, new Integer[]{});

        System.out.println(graph);
        System.out.println(connectedComponentsCount(graph));
    }
    private static void buildGraph(HashMap<Integer, ArrayList<Integer>> graph,Integer key, Integer[] values){
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(values));
        graph.put(key, list);
    }

    private static int connectedComponentsCount(HashMap<Integer, ArrayList<Integer>> graph){
        ArrayList<Integer> visited = new ArrayList<>();
        var count = 0;
        for (Integer key : graph.keySet()) {
            if(visited.contains(key)){
               continue;
            }
            count = explore(graph, visited, key,count);
        }
        return count;
    }

    private static int explore(HashMap<Integer, ArrayList<Integer>> graph, ArrayList<Integer> visited, Integer key, int count){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(key);
        while(queue.size() > 0){
            var current = queue.poll();
            if(!(visited.contains(current))) visited.add(current);
            for(Integer neighbour : graph.get(current)){
                if(!(visited.contains(neighbour))){
                    queue.offer(neighbour);
                    visited.add(neighbour);
                }
            }
        }
        count++;
        return count;
    }
}
