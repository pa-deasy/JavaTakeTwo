package strings;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringOperationsTest {
    @Test
    public void GivedSentenceWhenReversedThenMatchesExpectedOrder() {
        String sentence = "My name is Khan";
        String expected = "Khan is name My";

        String actual = StringOperations.reverseSentence(sentence);

        assertEquals(expected, actual);
    }

    @Test
    public void GivenStringWhenCanBeSegementedToWordsThenReturnTrue() {
        String[] words = {"apple", "pear", "pie"};
        Set<String> availableWords = new HashSet<String>(Arrays.asList(words));
        
        assertEquals(true, StringOperations.canBeSegmentedToWords(availableWords, "applepie"));
    }

    @Test
    public void GivenAnotherStringWhenCanBeSegementedToWordsThenReturnTrue() {
        String[] words = {"on", "now", "hello", "hell"};
        Set<String> availableWords = new HashSet<String>(Arrays.asList(words));
        
        assertEquals(true, StringOperations.canBeSegmentedToWords(availableWords, "hellonow"));
    }

    @Test
    public void GivenStringWhenCannotBeSegementedToWordsThenReturnFalse() {
        String[] words = {"apple", "pear", "pie"};
        Set<String> availableWords = new HashSet<String>(Arrays.asList(words));
        
        assertEquals(false, StringOperations.canBeSegmentedToWords(availableWords, "applepeer"));
    }

    @Test
    public void GivenBracesCountWhenPermutationsGeneratedThenMatchesExpectedPermutations() {
        String[] expected = {"{{{}}}", "{{}{}}", "{{}}{}", "{}{{}}", "{}{}{}"};
        
        String[] actual = StringOperations.balancedBracesPermutations(3);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void GivenStringWhenPermutationsGeneratedThenMatchesExpectedPermutations() {
        String[] expected = {"abc", "acb", "bac", "bca", "cab", "cba"};

        String[] actual = StringOperations.permutationsOf("abc");

        assertArrayEquals(expected, actual);
    }
}