package com.company;

import java.util.*;

public class Graph {
    private HashMap<Integer, Vertex> vertices;

    public Graph() {
        this.vertices = new HashMap<Integer, Vertex>();
    }

    public void addVertex(int vertexId) {
        // only add if non-existent
        if (vertices.get(vertexId) == null) {
            vertices.put(vertexId, new Vertex(vertexId));
        }
    }

    public Vertex getVertex(int vertexId) {
        return vertices.get(vertexId);
    }

    public void addEdge(int vertexId1, int vertexId2) {
        // only add if both vertices exist
        if ((vertices.get(vertexId1) != null) && (vertices.get(vertexId2) != null)) {
            // get relations and add new relation
            vertices.get(vertexId1).getRelations().add(vertexId2);
        }
    }

    public HashSet<Integer> getNeighbors(int vertexId) {
        return vertices.get(vertexId).getRelations();
    }

    public void bft(int startingVertexId) {
        // print each vertex value in bread-first
        // order beginning from startingVertex
        Queue<Integer> queue = new LinkedList<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();

        queue.add(startingVertexId);

        while (queue.size() > 0) {
            int current = queue.remove();
            if (!visited.contains(current)) {
                // print value
                System.out.println(current);
                visited.add(current);
                HashSet<Integer> neighbors = vertices.get(current).getRelations();
                // add relations
                if (neighbors.size() > 0) {
                    for (int neighbor: neighbors) {
                        queue.add(neighbor);
                    }
                }
            }
        }
    }

    public void dft(int startingVertexId) {
        // print each vertex value in depth-first
        // order beginning from startingVertex
        Stack<Integer> stack = new Stack<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();

        stack.push(startingVertexId);

        while (stack.size() > 0) {
            int current = stack.pop();
            if (!visited.contains(current)) {
                // print value
                System.out.println(current);
                visited.add(current);
                HashSet<Integer> neighbors = vertices.get(current).getRelations();
                // add relations
                if (neighbors.size() > 0) {
                    for (int neighbor: neighbors) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public ArrayList<Integer> bfs(int startingVertex, int destinationVertex) {
        // returns a list containing the shortest path from
        // the starting vertex to the destination vertex in
        // breadth-first fashion

        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<Integer>();
        ArrayList<Integer> path = new ArrayList<Integer>();

        path.add(startingVertex);
        queue.add(path);

        while (queue.size() > 0) {
            ArrayList<Integer> currentPath = queue.remove();
            int current = currentPath.get((currentPath.size() - 1));

            if (!visited.contains(current)) {
                // check value
                if (current == destinationVertex) {
                    return currentPath;
                }
                visited.add(current);
                HashSet<Integer> neighbors = vertices.get(current).getRelations();
                // add relations
                if (neighbors.size() > 0) {
                    for (int neighbor: neighbors) {
                        // deep copy path
                        ArrayList<Integer> copy = new ArrayList<Integer>(currentPath.size());
                        copy.addAll(currentPath);
                        copy.add(currentPath.size(), neighbor);
                        queue.add(copy);
                    }
                }
            }
        }
        return null;
    }

    public ArrayList<Integer> dfs(int startingVertex, int destinationVertex) {
        // returns a list containing the shortest path from
        // the starting vertex to the destination vertex in
        // breadth-first fashion

        Stack<ArrayList<Integer>> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<Integer>();
        ArrayList<Integer> path = new ArrayList<Integer>();

        path.add(startingVertex);
        stack.push(path);

        while (stack.size() > 0) {
            ArrayList<Integer> currentPath = stack.pop();
            int current = currentPath.get((currentPath.size() - 1));

            if (!visited.contains(current)) {
                // check value
                if (current == destinationVertex) {
                    return currentPath;
                }
                visited.add(current);
                HashSet<Integer> neighbors = vertices.get(current).getRelations();
                // add relations
                if (neighbors.size() > 0) {
                    for (int neighbor: neighbors) {
                        // deep copy path
                        ArrayList<Integer> copy = new ArrayList<Integer>(currentPath.size());
                        copy.addAll(currentPath);
                        copy.add(currentPath.size(), neighbor);
                        stack.push(copy);
                    }
                }
            }
        }
        return null;
    }
}
