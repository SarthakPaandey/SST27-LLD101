
public class Demo04 {
    public static void main(String[] args) {
        PaymentService ps = new PaymentService(new UPI());
        System.out.println(ps.pay(new Payment(499)));
    }
}
