package com.prepare.secondstructure.graphs;

import javax.swing.text.AttributeSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Stack;

public class GraphProblem1 {
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

    //using depth first search method;
    private static final Stack<Character> stack= new Stack<>();
    private static boolean hasPathState = false;
    public static void main(String[] args) {
        HashMap<Character, ArrayList<Character>> graph = new HashMap<>();
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

        //System.out.println(hasPath(graph,'f','i'));
        System.out.println(hasPath2(graph, 'f','k'));
    }

    public static void check(HashMap<Character, ArrayList<Character>> graph, Character desc){
        //writing the traversal code
        var current = stack.pop();
        var neighbours = graph.get(current);
        if(neighbours.contains(desc)) hasPathState = true;
        if(!(neighbours.isEmpty())){
            for (int i = neighbours.size()-1; i >= 0 ; i--) {
                stack.push(neighbours.get(i));
            }
        }
        if(stack.isEmpty()) return;
        check(graph, desc);
    }
    private static boolean hasPath(HashMap<Character, ArrayList<Character>> graph, Character src, Character desc){
        stack.push(src);;
        check(graph,desc);
        if(src.equals(desc)) return true;
        return hasPathState;
    }

    private static boolean hasPath2(HashMap<Character, ArrayList<Character>> graph, Character src,Character desc){
        if(src.equals(desc)) return true;
        for (Character neighbour : graph.get(src)) {
            if(hasPath2(graph, neighbour, desc)){ ;
                return true;
            }
        }
        return false;
    }
}
