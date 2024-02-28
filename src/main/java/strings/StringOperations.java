package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Stream;

public class StringOperations {
    public static String reverseSentence(String sentence) {
        String[] words = sentence.split(" ");
        int leftIndex = 0;
        int rightIndex = words.length - 1;

        while (leftIndex < rightIndex) {
            String temp = words[leftIndex];
            words[leftIndex] = words[rightIndex];
            words[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }

        return String.join(" ",words);
    }

    public static boolean canBeSegmentedToWords(Set<String> availableWords, String s) {
        for (int index = 1; index < s.length() + 1; index++) {
            String firstWord = s.substring(0, index);
            if (availableWords.contains(firstWord)) {
                String secondWord = s.substring(index);
                if (secondWord.length() == 0 || availableWords.contains(secondWord) || canBeSegmentedToWords(availableWords, secondWord)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static String[] balancedBracesPermutations(int n) {
        ArrayList<String> permutations = new ArrayList<String>();
        balancedBracesPermutations("", n, n, permutations);

        return permutations.toArray(new String[permutations.size()]);
    }

    private static void balancedBracesPermutations(String braces, int leftCount, int rightCount, ArrayList<String> permutations) {
        if (leftCount == 0 && rightCount == 0) {
            permutations.add(braces);
            return;
        }

        if (leftCount < 0 || rightCount < leftCount) {
            return;
        }

        String withLeft = braces + "{";
        balancedBracesPermutations(withLeft, leftCount - 1, rightCount, permutations);

        String withRight = braces + "}";
        balancedBracesPermutations(withRight, leftCount, rightCount - 1, permutations);
    }

    public static String[] permutationsOf(String word) {
        ArrayList<String> permutations = new ArrayList<String>();
        permutationsOf(word, "", permutations);

        return permutations.toArray(new String[permutations.size()]);
    }

    private static void permutationsOf(String remaining, String prefix, ArrayList<String> permutations) {
        if (remaining.length() == 0) {
            permutations.add(prefix);
        }

        for (int index = 0; index < remaining.length(); index++) {
            String newRemaining = remaining.substring(0, index) + remaining.substring(index + 1);
            String newPrefix = prefix + remaining.substring(index, index + 1);
            permutationsOf(newRemaining, newPrefix, permutations);
        }
    }

    public static boolean matchingRotations(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        String doubledFirst = first + first;
        return doubledFirst.contains(second);
    }

    // # You are given an array of strings products and string search_word.
    // # Design a system that suggests at most 3 product names for products are each character of search_word is typed.
    // # Suggested products should have common prefix with search_word.
    // # If there are more than three products with a common prefix return the three lexicographically minimum products.
    public static String[][] suggestProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        ArrayList<String[]> suggestions = new ArrayList<String[]>();
        int leftIndex = 0;
        int rightIndex = products.length - 1;

        for (int searchIndex = 0; searchIndex < searchWord.length(); searchIndex++) {
            while (leftIndex <= rightIndex && doesNotMatch(products[leftIndex], searchWord, searchIndex)) {
                leftIndex++;
            }
            while (leftIndex <= rightIndex && doesNotMatch(products[rightIndex], searchWord, searchIndex)) {
                rightIndex--;
            }

            int wordsLeft = rightIndex - leftIndex + 1;
            if (wordsLeft > 3) {
                suggestions.add(Arrays.copyOfRange(products, leftIndex, leftIndex + 3));
            }
            else if (wordsLeft > 0)  {
                suggestions.add(Arrays.copyOfRange(products, leftIndex, rightIndex + 1));
            }
            else {
                suggestions.add(new String[0]);
            }
        }

        return suggestions.toArray(new String[suggestions.size()][suggestions.size()]);
    }

    private static boolean doesNotMatch(String product, String searchWord, int searchIndex) {
        return product.length() - 1 < searchIndex || product.charAt(searchIndex) != searchWord.charAt(searchIndex);
    }

    // # You are given an array of logs. Each log is space-delimited string of words, where the first word is the identifier. There are two types of logs:
    // # - Letter-logs: All words except the identifier consist of lowercase english letters.
    // # - Digit-logs: All words except the identifier consist of digits.
    // # Reorder these logs so that:
    // # 1. The letter-logs come before all digit-logs.
    // # 2. The letter-logs are sorted lexographically by their contents. If their contents are the same, then sort them lexographically by their identifiers.
    // # 3. The digit-logs maintain their relative ordering.
    public static String[] reorderLogs(String[] logs) {
        ArrayList<String> letterLogs = new ArrayList<String>();
        ArrayList<String> digitLogs = new ArrayList<String>();

        for (String log: logs) {
            if (containsDigit(log)) {
                digitLogs.add(log);
            }
            else {
                letterLogs.add(log);
            }
        }

        String[] letterLogsArray = letterLogs.toArray(new String[letterLogs.size()]);
        String[] digitLogsArray = digitLogs.toArray(new String[digitLogs.size()]);

        Arrays.sort(letterLogsArray, new Comparator<String>() {
            public int compare(String first, String second) {
                int firstSpace = first.indexOf(" ");
                int secondSpace = second.indexOf(" ");
                first = first.substring(firstSpace);
                second = second.substring(secondSpace);

                return first.compareTo(second);
            }
        });

        return Stream.concat(Arrays.stream(letterLogsArray), Arrays.stream(digitLogsArray)).toArray(String[]::new);
    }

    private static boolean containsDigit(String log) {
        char lastChar = log.charAt(log.length() - 1);
        return Character.isDigit(lastChar);
    }
    
    public static int minimumDistanceBetween(String sentence, String firstWord, String secondWord) {
        String[] words = sentence.split(" ");
        int firstIndex = -1;
        int secondIndex = -1;
        int minimumDistance = -1;

        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            if (word.equals(firstWord)) {
                firstIndex = index;
                minimumDistance = setMinimumDistance(firstIndex, secondIndex, minimumDistance);
            }
            else if (word.equals(secondWord)) {
                secondIndex = index;
                minimumDistance = setMinimumDistance(firstIndex, secondIndex, minimumDistance);
            }
        }

        return minimumDistance;
    }

    private static int setMinimumDistance(int firstIndex, int secondIndex, int minimumDistance) {
        if (firstIndex == -1 || secondIndex == -1) { return minimumDistance; }

        int distance = Math.abs(firstIndex - secondIndex) - 1;
        return minimumDistance > -1 ? Math.min(minimumDistance, distance) : distance;
    }

    public static int wordLadder(HashSet<String> dictionary, String start, String target) {
        int ladder = 0;
        Queue<String> queue = new PriorityQueue<String>();
        queue.add(start);

        while (queue.size() > 0) {
            String current = queue.remove();
            ladder++;

            if (current.equals(target)) {
                return ladder;
            }
            
            for (String element: dictionary) {
                if (moreThanOneDiff(element, current)) {
                    continue;
                }
                else {
                    queue.add(element);
                    dictionary.remove(element);
                    break;
                }
            }
        }

        return -1;
    }

    private static boolean moreThanOneDiff(String first, String second) {
        if (first.length() != second.length()) {return false; }

        int diffs = 0;
        for (int index = 0; index < first.length(); index++) {
            if (first.charAt(index) != second.charAt(index)) { diffs++ ;}

            if (diffs > 1) { return true; }
        }

        return false;
    }
}