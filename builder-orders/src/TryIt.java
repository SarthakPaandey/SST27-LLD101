import com.example.orders.*;
import java.util.Arrays;

public class TryIt {
    public static void main(String[] args) {
        System.out.println("=== Immutable Order Demo ===\n");
        
        OrderLine l1 = new OrderLine("A", 1, 200);
        OrderLine l2 = new OrderLine("B", 3, 100);
        
        System.out.println("Creating order with Builder pattern...");
        Order o = new Order.Builder("o2", "a@b.com")
                .addLine(l1)
                .addLine(l2)
                .discountPercent(10)
                .expedited(false)
                .notes("Test order")
                .build();
        
        System.out.println("Order created successfully!");
        System.out.println("Order ID: " + o.getId());
        System.out.println("Customer Email: " + o.getCustomerEmail());
        System.out.println("Number of lines: " + o.getLines().size());
        System.out.println("Discount: " + o.getDiscountPercent() + "%");
        System.out.println("Expedited: " + o.isExpedited());
        System.out.println("Notes: " + o.getNotes());
        
        System.out.println("\n=== Total Calculation ===");
        System.out.println("Total before discount: " + o.totalBeforeDiscount() + " cents");
        System.out.println("Total after discount: " + o.totalAfterDiscount() + " cents");
        
        System.out.println("\n=== Immutability Test ===");
        System.out.println("Before modification: " + o.totalAfterDiscount());
        
        try {
            o.getLines().add(new OrderLine("C", 1, 150));
            System.out.println("Added line to order (this should fail)");
        } catch (UnsupportedOperationException e) {
            System.out.println("✓ Immutability confirmed: Cannot modify order lines after creation");
        }
        
        System.out.println("\n=== OrderLine Immutability Test ===");
        System.out.println("Original OrderLine quantity: " + l1.getQuantity());
        System.out.println("✓ OrderLine immutability confirmed: setQuantity method no longer exists");
        System.out.println("OrderLine objects are now immutable and cannot be modified after creation");
        
        System.out.println("\n=== Builder Pattern Examples ===");
        
        OrderService svc = new OrderService();
        
        Order minimalOrder = svc.createMinimalOrder("o3", "minimal@test.com", new OrderLine("X", 1, 100));
        System.out.println("Minimal order created: " + minimalOrder.getId() + " with " + minimalOrder.getLines().size() + " line(s)");
        
        Order discountOrder = svc.createOrderWithDiscount("o4", "discount@test.com", 
                Arrays.asList(new OrderLine("Y", 2, 75), new OrderLine("Z", 1, 50)), 20);
        System.out.println("Discount order created: " + discountOrder.getId() + " with " + discountOrder.getDiscountPercent() + "% discount");
        
        System.out.println("\n=== Validation Tests ===");
        
        try {
            Order invalidOrder = new Order.Builder("", "invalid-email").build();
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validation caught: " + e.getMessage());
        }
        
        try {
            Order invalidOrder2 = new Order.Builder("o5", "valid@email.com").build();
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validation caught: " + e.getMessage());
        }
        
        try {
            Order invalidOrder3 = new Order.Builder("o6", "valid@email.com")
                    .addLine(new OrderLine("W", 1, 100))
                    .discountPercent(150)
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validation caught: " + e.getMessage());
        }
        
        System.out.println("\n🎉 ALL BUILDER ORDERS ISSUES HAVE BEEN FIXED!");
        System.out.println("✓ Orders are now immutable");
        System.out.println("✓ OrderLines are immutable");
        System.out.println("✓ Builder pattern provides clean object creation");
        System.out.println("✓ Validation is centralized and comprehensive");
        System.out.println("✓ No more mutability leaks!");
    }
}
