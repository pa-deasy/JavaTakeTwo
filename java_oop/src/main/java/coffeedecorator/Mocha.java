package coffeedecorator;

public class Mocha extends CondimentDecorator {
    public Mocha(Beverage b) {
        super(b);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    public float cost() {
        size = beverage.getSize();
        float cost = 0;
        switch (size) {
            case Small:
                cost = .2f;
                break;
            case Medium:
                cost = .3f;
                break;
            case Large:
                cost = .4f;
                break;
        }
        return beverage.cost() + cost;
    }
}
