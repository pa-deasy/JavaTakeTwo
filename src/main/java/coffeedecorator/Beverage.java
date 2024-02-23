package coffeedecorator;

public abstract class Beverage {
    Size size;
    String description;

    public Beverage(Size s) {
        size = s;
        description = "Unknown Beverage";
    }

    public Size getSize() {
        return size;
    }

    public String getDescription() {
        return description;
    }

    public abstract float cost();
}
