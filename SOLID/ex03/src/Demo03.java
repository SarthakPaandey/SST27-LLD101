public class Demo03 {
    public static void main(String[] args) {
        System.out.println(new ShippingCostCalculator().cost(new Shipment(2.0, new Express())));
    }
}
