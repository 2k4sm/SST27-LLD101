public class WalletProcessor implements PaymentProcessor {
    @Override
    public String process(double amount) {
        return "Wallet debit: " + amount;
    }
}
