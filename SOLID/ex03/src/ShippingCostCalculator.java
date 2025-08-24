public class ShippingCostCalculator {
    public double cost(Shipment shipment) {
        ShippingStrategy strategy = ShippingStrategyFactory.getStrategy(shipment.getType());
        return strategy.calculateCost(shipment.getWeightKg());
    }
}
