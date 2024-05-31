package stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinStackTest {
    @Test
    public void givenMinStackWhenManipulatedThenBehavesAsExpected() {
        MinStack stack = new MinStack();

        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.peek());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.peek());

        stack.push(11);
        stack.push(4);
        assertEquals(4, stack.min());
        stack.pop();
        assertEquals(10, stack.min());
    }
}
