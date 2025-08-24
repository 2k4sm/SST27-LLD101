public class CardProcessor implements PaymentProcessor {
    @Override
    public String process(double amount) {
        return "Charged card: " + amount;
    }
}
