public class StandardTax implements TaxCalculator {
    @Override
    public double calculateTax(double subtotal) {
        return subtotal * 0.18;
    }
}