public class ShippingCostCalculator {

    double cost(Shipment s){
        return s.getStrategy().calculateShippingCost(s);
    }
}
