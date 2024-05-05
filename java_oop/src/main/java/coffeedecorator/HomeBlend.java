package coffeedecorator;

public class HomeBlend extends Beverage {
    public HomeBlend(Size s) {
        super(s);
        description = "Home Blend";
    }

    public float cost() {
        float cost = 0;
        switch (size) {
            case Small:
                cost = 2.50f;
                break;
            case Medium:
                cost = 3.50f;
                break;
            case Large:
                cost = 4.50f;
                break;
        }
        return cost;
    }
}
