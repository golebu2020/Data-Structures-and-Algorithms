package com.prepare.secondstructure.graph2;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class depthFirstAlgorithm {
/*
Write a function, hasPath, that takes in an object representing the adjacency list of a directed acyclic graph
and (src, ds). The function should return a boolean indicating whether or not there exists a directed
path between the source destination nodes.

const graph = {
f: ['g','i'],
g: ['h'],
h: [],
i: ['g','k'],
j:['i'],
k:[]
};
 */
    public static void main(String[] args) {
        HashMap<Character, ArrayList<Character>> graph = new HashMap<>();

        generateGraph('f', new Character[]{'g','i'}, graph);
        generateGraph('g', new Character[]{'h'},graph);
        generateGraph('h', new Character[]{}, graph);
        generateGraph('i', new Character[]{'g','k'}, graph);
        generateGraph('j', new Character[]{'i'}, graph);
        generateGraph('k', new Character[]{}, graph);

        System.out.println(graph);
        System.out.println(hasPath(graph, 'f','k'));
    }

    private static void generateGraph(Character key, Character[] values, HashMap<Character, ArrayList<Character>> graph ){
        ArrayList<Character> array = new ArrayList<>(Arrays.asList(values));
        graph.put(key, array);
    }

    private static boolean hasPath(HashMap<Character, ArrayList<Character>> graph,Character src, Character dst) {
        if (src.equals(dst)) return true;
        for(Character neighbour : graph.get(src)){
            if(hasPath(graph, neighbour, dst)) return true;
        }
        return false;
    }
}
