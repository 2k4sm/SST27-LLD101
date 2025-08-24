import java.util.HashMap;
import java.util.Map;

public class ShippingStrategyFactory {
    private static final Map<String, ShippingStrategy> strategies = new HashMap<>();

    static {
        strategies.put("STANDARD", new StandardShippingStrategy());
        strategies.put("EXPRESS", new ExpressShippingStrategy());
        strategies.put("OVERNIGHT", new OvernightShippingStrategy());
    }

    public static ShippingStrategy getStrategy(String type) {
        ShippingStrategy strategy = strategies.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("Unknown shipping type: " + type);
        }
        return strategy;
    }
}
