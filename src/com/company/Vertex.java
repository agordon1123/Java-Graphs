package com.company;

import java.util.HashSet;

public class Vertex {
    private int value;
    private HashSet<Integer> relations;

    public Vertex(int value) {
        this(value, new HashSet<Integer>());
    }

    public Vertex(int value, HashSet<Integer> relations) {
        this.value = value;
        this.relations = relations;
    }

    public int getValue() {
        return value;
    }

    public HashSet<Integer> getRelations() {
        return relations;
    }

}
