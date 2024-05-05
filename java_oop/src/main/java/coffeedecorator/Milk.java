package coffeedecorator;

public class Milk extends CondimentDecorator {
    public Milk(Beverage b) {
        super(b);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    public float cost() {
        size = beverage.getSize();
        float cost = 0;
        switch (size) {
            case Small:
                cost = .1f;
                break;
            case Medium:
                cost = .2f;
                break;
            case Large:
                cost = .3f;
                break;
        }
        return beverage.cost() + cost;
    }
}
