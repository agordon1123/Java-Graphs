package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Todo: create graph structure
        // Todo: create stack structure

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
    }
}