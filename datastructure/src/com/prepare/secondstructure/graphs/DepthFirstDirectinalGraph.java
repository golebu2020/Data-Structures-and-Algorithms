package com.prepare.secondstructure.graphs;

import java.util.*;

public class DepthFirstDirectinalGraph {
    private static final HashMap<Character, ArrayList<Character>> graph = new HashMap<>();
    private static Stack<Character> stack = new Stack<>();
    private static Queue<Character> queue = new LinkedList<>();
    private static int traverseCounter = 0;

    public static void main(String[] args) {
        generateGraph('a',new Character[]{'b','c'});
        generateGraph('b',new Character[]{'d'});
        generateGraph('c',new Character[]{'e'});
        generateGraph('d',new Character[]{'f'});
        generateGraph('e',new Character[]{});
        generateGraph('f',new Character[]{});


        System.out.println(graph);
        stack.push('a');
        System.out.println("=========================Depth First Traversal Algorithm=========================");
        depthFirstAlgorithm();
        System.out.println("=========================Breadth First Traversal Algorithm=========================");
        queue.offer('a');
        breathFirstAlgorithm();

    }

    private static void generateGraph(Character key, Character[] values){
        ArrayList<Character> array = new ArrayList<>(Arrays.asList(values));
        graph.put(key, array);
    }

    private static void depthFirstAlgorithm(){
        var current = stack.pop();
        var neighbours = graph.get(current);
        System.out.println(current);
        if(!(neighbours.isEmpty())){
            for (int i = neighbours.size()-1; i >= 0; i--) {
                stack.push(neighbours.get(i));
            }
        }
        if(stack.isEmpty()){
            return;
        }
        depthFirstAlgorithm();
   }

    private static void breathFirstAlgorithm(){
        var current = queue.poll();
        var neighbours = graph.get(current);
        System.out.println(current);
        if(!(neighbours.isEmpty())){
            for (int i = 0; i < neighbours.size() ; i++) {
                queue.offer(neighbours.get(i));
            }
        }
        if(queue.isEmpty()){
            return;
        }
        breathFirstAlgorithm();
    }

}
