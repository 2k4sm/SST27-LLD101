public class OrderService {
    private final TaxCalculator taxCalculator;
    private final EmailService emailService;

    public OrderService(TaxCalculator taxCalculator, EmailService emailService) {
        this.taxCalculator = taxCalculator;
        this.emailService = emailService;
    }

    public double totalWithTax(double subtotal) {
        return subtotal + taxCalculator.calculateTax(subtotal);
    }

    public void checkout(String customerEmail, double subtotal) {
        double total = totalWithTax(subtotal);
        emailService.send(customerEmail, "Thanks! Your total is " + total);
        System.out.println("Order stored (pretend DB).");
    }
}
