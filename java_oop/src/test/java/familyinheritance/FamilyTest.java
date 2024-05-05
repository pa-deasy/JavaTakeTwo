package familyinheritance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class FamilyTest {
    @Test
    public void GivenParentWhenBornThenHasExpectedHairAndLanguage() {
        Parent dad = new Parent();
        String[] expectedLanguages = {"English"};

        assertEquals("Brown", dad.hair);
        assertArrayEquals(expectedLanguages, dad.languages.toArray());
    }

    @Test
    public void GivenChildWhenBornThenHasExpectedHairAndLanguages() {
        Child son = new Child();
        String[] expectedLanguages = {"English", "Cantonese"};

        assertEquals("Brown", son.hair);
        assertArrayEquals(expectedLanguages, son.languages.toArray());
    }
    
}