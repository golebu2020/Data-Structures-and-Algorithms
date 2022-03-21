package com.prepare.secondstructure.graphs;

import com.sun.security.jgss.GSSUtil;

import java.util.*;

//write a function, connectedComponentsCont, that takes in the adjacency
//list of an undirected graph. The function should return the number of connected
//components within the graph.

/* connectedComponentsCount({
 0:[8,1,5],
 1:[0],
 5:[0,8],
 8:[0,5],
 2:[3,4],
 3:[2,4],
 4:[3,2]
 })
 */

public class ConnectedComponentGraph {
    private static final HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();
    private static final Stack<Integer> stack = new Stack<>();
    private static final ArrayList<Integer> visited = new ArrayList<>();
    private static int count = 0;
    private static int tracker = 0;

    public static void main(String[] args) {

        buildEdges(2, new Integer[]{1});
        buildEdges(3, new Integer[]{});
        buildEdges(4, new Integer[]{6});
        buildEdges(5, new Integer[]{6});
        buildEdges(1, new Integer[]{2});
        buildEdges(6, new Integer[]{4, 5, 7, 8});
        buildEdges(7, new Integer[]{6});
        buildEdges(8, new Integer[]{6});
        System.out.println(edges);
        System.out.println(connectedComponents(edges));

    }

    private static void buildEdges(Integer key, Integer[] values) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(values));
        edges.put(key, arrayList);
    }

    private static int connectedComponents(HashMap<Integer, ArrayList<Integer>> edges) {
        //using the depth first approach
        for (var node: edges.keySet()) {
            stack.push(node);
            if(explore()){
                count++;
            }
        }
        return count;
    }

    private static boolean explore(){
        var current= stack.pop();
        var neighbours = edges.get(current);
        if(!visited.contains(current)) visited.add(current);
        if(neighbours==null) return true;
        for(Integer neighbour: neighbours){
            if(!(visited.contains(neighbour))){
                visited.add(neighbour);
                stack.push(neighbour);
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        explore();
        return false;
    }
}

//  for (Integer node: edges.keySet())
//          if(explore(edges, node))
//          count++;
//          return count;
//
//          if(visited.contains(current))
//          return false;
//          visited.add(current);
//          for (Integer neighbour: edges.get(current))
//          explore(edges,neighbour);
//          return true;
