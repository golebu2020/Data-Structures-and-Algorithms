package com.prepare.secondstructure.graph2;

import java.util.*;

public class ShortestPath {
    /*
    Write a function, shortestPath, that takes in an array of edges for an undirected graph
    and two nodes (nodeA, nodeB). The function should return the length of the shortest path
    between A and B. Consider teh length as the number of edges in the path, not the number of nodes.
    If there is no path between A and B, then return -1.

    test_00:
    const_edges = [
    ['W','X'],
    ['X','Y'],
    ['Z','Y'],
    ['Z','V'],
    ['W','V],
    ];
    shortesPath(edges, 'w','z'); //--> 2
     */
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        buildGraph(graph, "W", new String[]{"X","V"});
        buildGraph(graph, "X", new String[]{"W","Y"});
        buildGraph(graph, "Y", new String[]{"X","Z"});
        buildGraph(graph, "Z", new String[]{"Y","V"});
        buildGraph(graph, "V", new String[]{"W","Z"});

        System.out.println(graph);
        System.out.println(findShortestPath(graph, "W","Z"));
    }

    private static void buildGraph(HashMap<String, ArrayList<String>> graph, String key, String[] values){
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(values));
        graph.put(key, list);
    }

    private static int findShortestPath(HashMap<String, ArrayList<String>> graph, String start, String end){
        ArrayList<String> visited = new ArrayList<>();
        Queue<TreeSet> queue = new LinkedList<>();
        TreeSet<String> set = new TreeSet<>();
        set.add(start);
        set.add(String.valueOf(0));
        queue.add(set);
        while(queue.size() > 0){
            var current = queue.poll();
            String node = (String) current.last();
            int distance = Integer.parseInt(current.first().toString());
            if(node.equals(end)) return distance;
            if(!visited.contains(node)) visited.add(node);
            for(String neighbour: graph.get(node)){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    TreeSet<String> set2 = new TreeSet<>();
                    set2.add(neighbour);
                    set2.add(String.valueOf(distance + 1));
                    queue.add(set2);
                }
            }
        }
        return -1;
    }
}
