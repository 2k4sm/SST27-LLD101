import java.util.HashMap;
import java.util.Map;

public class PaymentProcessorFactory {
    private static final Map<String, PaymentProcessor> processors = new HashMap<>();

    static {
        processors.put("CARD", new CardProcessor());
        processors.put("UPI", new UpiProcessor());
        processors.put("WALLET", new WalletProcessor());
    }

    public static PaymentProcessor getProcessor(String provider) {
        PaymentProcessor processor = processors.get(provider);
        if (processor == null) {
            throw new RuntimeException("No provider: " + provider);
        }
        return processor;
    }
}
