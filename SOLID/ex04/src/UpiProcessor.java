public class UpiProcessor implements PaymentProcessor {
    @Override
    public String process(double amount) {
        return "Paid via UPI: " + amount;
    }
}
