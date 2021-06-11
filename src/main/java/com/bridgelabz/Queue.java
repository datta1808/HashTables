package com.bridgelabz;

public class Queue<T> {
    MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

    /* enqueue the Node to queue */
    public void enqueue(INode newNode) {
        myLinkedList.addLast(newNode);
    }

    /* peek the top node in queue */
    public INode peek() {
        return myLinkedList.head;
    }

    /* dequeue node in the queue */
    public INode dequeue() {
        return myLinkedList.popFirst();
    }
}