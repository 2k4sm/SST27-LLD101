
public class Demo01 {
    public static void main(String[] args) {
        TaxCalculator taxCalculator = new StandardTaxCalculator(0.18);
        EmailService emailService = new EmailClient();
        OrderService orderService = new OrderService(taxCalculator, emailService);

        orderService.checkout("a@shop.com", 100.0);
    }
}
