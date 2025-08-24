public class OrderService {
    // double taxRate = 0.18;
    // EmailClient email = new EmailClient();
    NotificationService email;
    TaxCalculator taxCalculator;
    DatabaseStorage databaseStorage;
    public OrderService(NotificationService email, TaxCalculator taxCalculator, DatabaseStorage databaseStorage) {
        this.email = email;
        this.taxCalculator = taxCalculator;
        this.databaseStorage = databaseStorage;
    }
    
    void checkout(String customerEmail, double subtotal) {
        // double total = totalWithTax(subtotal);
        // email.send(customerEmail, "Thanks! Your total is " + total);
        // System.out.println("Order stored (pretend DB).");
        double total = subtotal + taxCalculator.calculateTax(subtotal);
        databaseStorage.storeOrder(customerEmail, subtotal, total);
        email.send(customerEmail, "Thanks! Your total is " + total);
    }
}