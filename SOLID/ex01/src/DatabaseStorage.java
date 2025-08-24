public interface DatabaseStorage {
    void storeOrder(String customerEmail, double subtotal, double total);
}