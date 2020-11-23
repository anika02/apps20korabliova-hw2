package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList queue = new ImmutableLinkedList();

    public Queue() {    }

    Object peek() {
        return queue.getFirst();
    }

    Object dequeue() {
        Object temp = this.peek();
        this.queue = this.queue.removeFirst();
        return temp;
    }

    void enqueue(Object e) {
        this.queue = this.queue.addLast(e);
    }

}
