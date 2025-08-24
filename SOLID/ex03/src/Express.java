public class Express implements ShippingStrategy {
    @Override
    public double calculateShippingCost(Shipment shipment) {
        return 80 + 8*shipment.weightKg;
    }
}