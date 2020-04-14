package com.company;

public class Node {
    private String key;
    private String value;
    private Node[] relationships;

    public Node(String key, String value) {
        this(key, value, new Node[5]);
    }

    public Node(String key, String value, Node[] relationships) {
        this.key = key;
        this.value = value;
        this.relationships = relationships;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    private Node[] getRelationships() {
        return relationships;
    }

    // will need to figure out how to add relationships (pointer?) (size?)
}
