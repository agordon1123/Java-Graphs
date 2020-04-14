package com.company;

public class MyStack {

    private int length;
    private Node[] storage;
    private int stackPointer;

    public MyStack() {
        this(5, new Node[5], 0);
    }

    public MyStack(int length) {
        this(length, new Node[length], 0);
    }

    public MyStack(int length, Node[] storage, int stackPointer) {
        this.length = length;
        this.storage = storage;
        this.stackPointer = stackPointer;
    }

    public int getLength() {
        return length;
    }

    public Node[] getStorage() {
        return storage;
    }

    public int getStackPointer() {
        return stackPointer;
    }

    public void push(Node node) {
        // auto resizing up at 80% capacity
        double fill = (double) stackPointer / length;
        if (fill >= .8) {
            resizeUp();
        }
        storage[stackPointer] = node;
        stackPointer++;
    }

    public Node pop() {
        // auto resizing up at 20% capacity
        // will cause auto downside upon creation if length passed in
        double fill = (double) stackPointer / length;
        if (fill <= .20) {
            resizeDown();
        }
        stackPointer--;
        Node node = storage[stackPointer];
        storage[stackPointer] = null;
        return node;
    }

    public void resizeUp() {
        length *= 2;
        Node[] newStorage = new Node[length];

        for (int i = 0; i < storage.length; i++) {
            newStorage[i] = storage[i];
        }
        storage = newStorage;
    }

    public void resizeDown() {
        length /= 2;
        Node[] newStorage = new Node[length];

        int counter = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                newStorage[counter] = storage[i];
                counter++;
            }
        }
        if (counter > storage.length) {
            // edge case that storage should not have been resized down
            length = storage.length;
            return;
        } else {
            storage = newStorage;
        }
    }

}
