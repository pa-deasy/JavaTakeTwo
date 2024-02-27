package strings;

import java.util.ArrayList;
import java.util.Set;

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
}