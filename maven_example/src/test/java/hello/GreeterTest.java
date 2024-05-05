package hello;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GreeterTest {
    private Greeter greeter = new Greeter();

    @Test
    public void greeterSaysHello() {
        assertEquals("Hello World!", greeter.sayHello());
    }
}
