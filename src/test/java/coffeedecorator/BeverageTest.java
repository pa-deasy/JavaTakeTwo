package coffeedecorator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BeverageTest {
    @Test
    public void GivenBeverageWhenSmallHomeBlendWithTwoMilkThenCorrectCostAndDescription() {
        Beverage beverage = new Milk(new Milk(new HomeBlend(Size.Small)));
        assertEquals(2.7f, beverage.cost(), 1);
        assertEquals("Home Blend, Milk, Milk", beverage.getDescription());
    }

    @Test
    public void GivenBeverageWhenLargeDarkRoastMochaThenCorrectCostAndDescription() {
        Beverage beverage = new Mocha(new DarkRoast(Size.Large));
        assertEquals(5.4f, beverage.cost(), 0);
        assertEquals("Dark Roast, Mocha", beverage.getDescription());
    }
}
