package recursion;

import java.util.HashMap;
import java.util.Map;

public class RecursionOperations {
    public static int nthFibonacci(Integer n) {
        return nthFibonacci(n, new HashMap<>());
    }

    private static int nthFibonacci(Integer n, Map<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (!memo.containsKey(n)) {
            memo.put(n, nthFibonacci(n - 1, memo) + nthFibonacci(n - 2, memo));
        }

        return memo.get(n);
    }
}