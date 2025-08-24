public class Demo01 {
    public static void main(String[] args) {
        NotificationService emailService = new EmailClient();
        TaxCalculator taxCalculator = new StandardTax();
        DatabaseStorage databaseStorage = new Storage();
        OrderService orderService = new OrderService(emailService, taxCalculator, databaseStorage);
        orderService.checkout("a@shop.com", 100.0);
    }
}
