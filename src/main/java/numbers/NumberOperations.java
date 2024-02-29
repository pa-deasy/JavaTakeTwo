package numbers;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class NumberOperations {
    // # Given an array of numbers in sorted order count the pairs of numbers whose whose sum is less than x.
    public static int totalPairsLessThan(int[] numbers, int target) {
        int totalPairs = 0;
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;

        while (leftIndex < rightIndex) {
            int sum = numbers[leftIndex] + numbers[rightIndex];

            if (sum < target) {
                totalPairs += rightIndex - leftIndex;
                leftIndex++;
            }
            else {
                rightIndex--;
            }
        }

        return totalPairs;
    }

    // # Given a range of numbers, count the numbers which have the same first and last digits.
    // # E.g. between 7 and 20 such numbers are 8, 9, 11
    public static int sameFirstAndLastInRange(int start, int end) {
        int upToEnd = sameFirstAndLastUpTo(end);
        int upToStart = sameFirstAndLastUpTo(start);

        return upToEnd - upToStart;
    }

    private static int sameFirstAndLastUpTo(int end) {
        int same = 0;

        if (end > 9) {
            same += 9;
        }
        else {
            return end;
        }

        if (end > 100) {
            same += 9;
        }
        else {
            same += (end - 10) / 10;
            return lastDigitLargerThanOrEqualToFirst(end) ? same + 1 : same;
        }

        same += (end - 99) / 10;
        return lastDigitLargerThanOrEqualToFirst(end) ? same + 1 : same;
    }

    private static boolean lastDigitLargerThanOrEqualToFirst(int n) {
        String number = String.valueOf(n);
        char[] digits = number.toCharArray();
        return (int) digits[digits.length - 1] >= (int) digits[0];
    }

    // # Suppose there are millions of numbers and you need to print the max 5 elements. How would you do that?
    public static int[] maxN(int[] numbers, int n) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        for (int number : numbers) {
            if (heap.size() < n) {
                heap.add(number);
            }
            else if (heap.peek() < number) {
                heap.poll();
                heap.add(number);
            }
        }

        return heap.stream().mapToInt(x->x).toArray();
    }

    // # Suppose there are n bags containing different amounts of chocolates and there is a wizard and a kid. At every second the kid eats all chocolates from the bag containing maximum number
    // # of chocolates and the wizard refills it with half the chocolates it was containing earlier. Find how many chocolates the kid has eaten at t seconds.
    public static int calculateChocolatesEaten(Integer[] chocolates, int t) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        heap.addAll(Arrays.asList(chocolates));

        int eaten = 0;
        for (int time = 0; time < t; time++) {
            int most = heap.poll();
            eaten += most;
            heap.add(most / 2);
        }

        return eaten;
    }
}