public class Shipment {
    double weightKg;ShippingStrategy strategy;
    // Shipment(String type, double w){ this.type=type; this.weightKg=w; }
    public Shipment(double w, ShippingStrategy strategy) {
        this.weightKg = w;
        this.strategy = strategy;
    }
    public ShippingStrategy getStrategy() {
        return strategy;
    }
}