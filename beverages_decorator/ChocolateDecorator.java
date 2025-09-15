package beverages_decorator;

public class ChocolateDecorator extends BeverageDecorator {

    public ChocolateDecorator(Beverage b) {
        super(b);
    }

    @Override
    public int cost() {
        return this.beverage.cost() + 100;
    }

}
