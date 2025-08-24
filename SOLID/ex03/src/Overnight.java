public class Overnight implements ShippingStrategy {
    @Override
    public double calculateShippingCost(Shipment shipment) {
        return 120 + 10*shipment.weightKg;
    }
}