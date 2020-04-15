package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);

        graph.addEdge(5, 3);
        graph.addEdge(6, 3);
        graph.addEdge(7, 1);
        graph.addEdge(4, 7);
        graph.addEdge(1, 2);
        graph.addEdge(7, 6);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(2, 3);
        graph.addEdge(4, 6);

        System.out.println(graph.dfs(1, 6));

        // Earliest ancestor challenge ->
        // I instantiated a 3-d array and don't know how to fix it :(
        ArrayList<Integer[][]> ancestorList = new ArrayList<Integer[][]>();
        ancestorList.add(new Integer[][] {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 9}, {11, 8}, {10, 1}});
        System.out.println(earliestAncestor(ancestorList, 6));
    }

    public static int earliestAncestor(ArrayList<Integer[][]> ancestors, int startingVertex) {
        Graph graph = new Graph();
        // add to graph
        for (int i = 0; i < ancestors.get(0).length; i++) {
            Integer[] current = ancestors.get(0)[i];
            graph.addVertex(current[0]);
            graph.addVertex(current[1]);
            // add edges backward to traverse upward
            graph.addEdge(current[1], current[0]);
        }

        HashSet<Integer> visited = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(startingVertex);

        while (queue.size() > 0) {
            int current = queue.remove();
            if (!visited.contains(current)) {
                visited.add(current);
                // add neighbors
                HashSet<Integer> neighbors = graph.getNeighbors(current);
                if (neighbors.size() > 0) {
                    for (int neighbor: neighbors) {
                        queue.add(neighbor);
                    }
                }
                if (queue.size() == 0) {
                    return current;
                }
            }
        }
        return -1;
    }
}