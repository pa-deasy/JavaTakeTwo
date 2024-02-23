package coffeedecorator;

public class DarkRoast extends Beverage {
    public DarkRoast(Size s) {
        super(s);
        description = "Dark Roast";
    }

    public float cost() {
        float cost = 0;
        switch (size) {
            case Small:
                cost = 3;
                break;
            case Medium:
                cost = 4;
                break;
            case Large:
                cost = 5;
                break;
        }
        return cost;
    }
}
