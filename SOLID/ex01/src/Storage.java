public class Storage implements DatabaseStorage {
    @Override
    public void storeOrder(String customerEmail, double subtotal, double total) {
        System.out.println("Order stored (pretend DB).");
    }
}