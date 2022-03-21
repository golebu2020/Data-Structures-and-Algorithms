package com.prepare.secondstructure.graph2;

import java.lang.reflect.Array;
import java.util.*;

public class LargestComponent {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>>  graph = new HashMap<>();
        buildGraph(graph, 1,new Integer[]{0});
        buildGraph(graph, 0,new Integer[]{1, 5, 8});
        buildGraph(graph, 5,new Integer[]{0, 8});
        buildGraph(graph, 8,new Integer[]{5, 0});
        buildGraph(graph, 4,new Integer[]{2, 3});
        buildGraph(graph, 2,new Integer[]{3, 4});
        buildGraph(graph, 3,new Integer[]{4, 2});

        System.out.println(graph);
        System.out.println(getLargestComponent(graph));
    }

    private static void buildGraph(HashMap<Integer, ArrayList<Integer>> graph, Integer key, Integer[] values){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(values));
        graph.put(key, list);
    }
    private static int getLargestComponent(HashMap<Integer, ArrayList<Integer>> graph){
        int largestComponent = 0;
        ArrayList<Integer> visited = new ArrayList<>();
        for(Integer key: graph.keySet()){
            int count= 0;
            if(visited.contains(key)) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(key);
            while(queue.size() > 0){
                var current = queue.poll();
                count++;
                if(!(visited.contains(current))) visited.add(current);
                for(Integer neighbour: graph.get(current)){
                    if(!(visited.contains(neighbour))){
                        queue.offer(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            if(count > largestComponent) largestComponent = count;
        }
        return largestComponent;
    }
}
