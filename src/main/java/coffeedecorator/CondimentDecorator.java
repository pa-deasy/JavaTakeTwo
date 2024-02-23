package coffeedecorator;

public abstract class CondimentDecorator extends Beverage {
    Beverage beverage;
    public CondimentDecorator(Beverage b) {
        super(b.size);
        beverage = b;
    }

    public abstract String getDescription();
    public abstract float cost();
}
