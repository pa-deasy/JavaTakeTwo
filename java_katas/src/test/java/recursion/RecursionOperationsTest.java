package recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecursionOperationsTest {
    @Test
    public void givenNthFibonacciWhenCalculatedThenReturnsExpectedNumber() {
        int fib = RecursionOperations.nthFibonacci(8);
        assertEquals(21, fib);
        // 0 1 1 2 3 5 8 13 21
    }
}
