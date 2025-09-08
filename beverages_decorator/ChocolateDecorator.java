package beverages_decorator;

public class ChocolateDecorator extends Beverage {

    private Beverage beverage;
    public ChocolateDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        return beverage.cost() + 100;
    }
}