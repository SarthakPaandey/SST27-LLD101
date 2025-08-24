public class Standard implements ShippingStrategy {
    @Override
    public double calculateShippingCost(Shipment shipment) {
        return 50 + 5*shipment.weightKg;
    }
}