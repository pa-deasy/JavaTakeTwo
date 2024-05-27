package linkedlist;

import org.junit.Test;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class LinkedListQueueTest {
    @Test
    public void whenOperatedOnThenBehavesAsExpected() {
        LinkedListQueue queue = new LinkedListQueue();
        assertEquals(Optional.empty(), queue.peek());
        queue.enqueue(9);
        assertEquals(Optional.of(9), queue.peek());
        queue.enqueue(7);
        queue.enqueue(12);
        assertEquals(Optional.of(9), queue.dequeue());
        assertEquals(Optional.of(7), queue.peek());
        assertEquals(Optional.of(7), queue.dequeue());
        assertEquals(Optional.of(12), queue.peek());
        assertEquals(Optional.of(12), queue.dequeue());
        assertEquals(Optional.empty(), queue.peek());
        assertEquals(Optional.empty(), queue.dequeue());
        queue.enqueue(20);
        assertEquals(Optional.of(20), queue.peek());
    }
}