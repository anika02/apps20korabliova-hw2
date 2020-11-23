package ua.edu.ucu.collections;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void testQueue() {
        Queue queue = new Queue();
        assertNull(queue.peek());
    }

    @Test
    public void testPeekEnqueueDequeue() {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.peek());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.peek());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.peek());
        assertEquals(3, queue.dequeue());

    }

}
