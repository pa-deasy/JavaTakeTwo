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

    @Test
    public void GivenStringWhenCheckedForMatchingRotationThenReturnsExpectedBoolean() {
        assertEquals(false, StringOperations.matchingRotations("abcc", "cbac"));
        assertEquals(false, StringOperations.matchingRotations("abcdef", "zb"));
        assertEquals(false, StringOperations.matchingRotations("abc", "ab"));
        assertEquals(true, StringOperations.matchingRotations("HELLO", "LOHEL"));
    }

    @Test
    public void GivenProductsWhenSearchWordProvidedThenReturnsExpectedSuggestions() {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad", "zebra"};
        String[][] expected = {
            {"mobile", "moneypot", "monitor"}, 
            {"mobile", "moneypot", "monitor"},
            {"mouse", "mousepad"},
            {"mouse", "mousepad"},
            {"mouse", "mousepad"}
        };

        String[][] actual = StringOperations.suggestProducts(products, "mouse");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void GivenLogsWhenOrderedThenMatchesExpectedOrder() {
        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] expected = {"let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"};

        String[] actual = StringOperations.reorderLogs(logs);
        
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void GivenTwoWordsInSentenceWhenMinimumDistanceCalculatedThenExpectedDistanceReturned() {
        String sentence = "geeks for geeks contribute practice";
        String firstWord = "geeks";
        String secondWord = "practice";

        int distance = StringOperations.minimumDistanceBetween(sentence, firstWord, secondWord);

        assertEquals(1, distance);
    }

    @Test
    public void GivenArrayOfStringsWhenPathExistsFromStartToTargetThenReturnsLadderDistance() {
        String[] elements = {"POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"};
        HashSet<String> dictionary = new HashSet<String>(Arrays.asList(elements));

        int ladder = StringOperations.wordLadder(dictionary, "TOON", "PLEA");

        assertEquals(7, ladder);
    }

    @Test
    public void GivenAnotherArrayOfStringsWhenPathExistsFromStartToTargetThenReturnsLadderDistance() {
        String[] elements = {"ABCD", "EBAD", "EBCD", "XYZA"};
        HashSet<String> dictionary = new HashSet<String>(Arrays.asList(elements));

        int ladder = StringOperations.wordLadder(dictionary, "ABCV", "EBAD");

        assertEquals(4, ladder);
    }
}



// @pytest.mark.parametrize(
//     'dictionary,start,target,expected',
//     [
//         pytest.param({'POON', 'PLEE', 'SAME', 'POIE', 'PLEA', 'PLIE', 'POIN'}, 'TOON', 'PLEA', 7),
//         pytest.param({'ABCD', 'EBAD', 'EBCD', 'XYZA'}, 'ABCV', 'EBAD', 4)
//     ]
// )
// def test_word_ladder_when_path_possible_returns_correct_step_count(dictionary, start, target, expected):
//     actual = word_ladder(dictionary, start, target)
    
//     assert actual == expected