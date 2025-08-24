public class StandardTaxCalculator implements TaxCalculator {
    private double taxRate;

    public StandardTaxCalculator(double taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public double calculateTax(double subtotal) {
        return subtotal * taxRate;
    }
}
