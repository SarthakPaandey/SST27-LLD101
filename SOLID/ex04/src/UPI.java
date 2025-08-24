public class UPI implements ProvidingCompany {
    @Override
    public String provide(Payment p) {
        return "Paid via UPI: " + p.amount;
    }
}