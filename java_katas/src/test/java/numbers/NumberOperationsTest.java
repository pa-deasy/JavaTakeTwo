package numbers;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class NumberOperationsTest {
    @Test
    public void GivenNumbersWhenExistsElementsLessThanTargetThenExpectedElementsAreReturned() {
        int[] numbers = {5, 7, 9, 10, 24, 55, 70};

        int pairs = NumberOperations.totalPairsLessThan(numbers, 30);

        assertEquals(7, pairs);
    }

    @Test
    public void GivenRangesWhenSameFirstAndLastExistThenCorrectCountReturned() {
        assertEquals(9, NumberOperations.sameFirstAndLastInRange(0, 10));
        assertEquals(9, NumberOperations.sameFirstAndLastInRange(10, 100));
        assertEquals(10, NumberOperations.sameFirstAndLastInRange(100, 200));
        assertEquals(100, NumberOperations.sameFirstAndLastInRange(1000, 2000));
        assertEquals(3, NumberOperations.sameFirstAndLastInRange(7, 20));
        assertEquals(2, NumberOperations.sameFirstAndLastInRange(100, 112));
        assertEquals(1, NumberOperations.sameFirstAndLastInRange(20, 24));
        assertEquals(20, NumberOperations.sameFirstAndLastInRange(305, 505));
        assertEquals(100, NumberOperations.sameFirstAndLastInRange(1005, 2005));
    } 
    
    @Test
    public void GivenNumbersWhenMaximumFiveObtainedThenMatchesExpectedNumbers() {
        int[] numbers = {67, 33, 22, 11, 34, 109, 1005, 3333, 555, 332, 221, 999, 33321};
        int[] expected = {555, 999, 1005, 3333, 33321};

        int[] actual = NumberOperations.maxN(numbers, 5);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void GivenBagsOfChocolatesWhenTimeTIsReachedThenTheExpectedNumberOfChocolatesHaveBeenEaten() {
        Integer[] chocolates = {18, 12, 60};

        int eaten = NumberOperations.calculateChocolatesEaten(chocolates, 5);

        assertEquals(135, eaten);
    }
}