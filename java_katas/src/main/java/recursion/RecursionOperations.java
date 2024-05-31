package recursion;

import java.util.*;

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

    public static Optional<Integer> findKthPermutation(Integer number, Integer k) {
        ArrayList<String> permutations = new ArrayList<>();
        Optional<String> kth = findKthPermutation(String.valueOf(number), "", permutations, k);

        return kth.map(Integer::parseInt);
    }

    private static Optional<String> findKthPermutation(String remaining, String prefix, ArrayList<String> permutations, Integer k) {
        if (remaining.isEmpty()) {
            permutations.add(prefix);
            return permutations.size() == k ? Optional.of(prefix) : Optional.empty();
        }

        for (int index = 0; index < remaining.length(); index++) {
            String newRemaining = remaining.substring(0, index) + remaining.substring(index + 1);
            String newPrefix = prefix + remaining.charAt(index);
            Optional<String> kth = findKthPermutation(newRemaining, newPrefix, permutations, k);
            if (kth.isPresent()) {
                return kth;
            }
        }
        return Optional.empty();
    }
}