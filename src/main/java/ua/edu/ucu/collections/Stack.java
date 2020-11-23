package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stack = new ImmutableLinkedList();

    public Stack() {    }

    Object peek() {
        return stack.getFirst();
    }

    Object pop() {
        Object temp = this.peek();
        this.stack = this.stack.removeFirst();
        return temp;
    }

    void push(Object e) {
        this.stack = this.stack.addFirst(e);
    }

}
