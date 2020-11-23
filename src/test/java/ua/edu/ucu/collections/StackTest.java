package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void teststack() {
        Stack stack = new Stack();
        assertNull(stack.peek());
    }

    @Test
    public void testPeekPushPop() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.peek());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.peek());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.peek());
        assertEquals(1, stack.pop());

    }
}
