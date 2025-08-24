public class Wallet implements ProvidingCompany {
    @Override
    public String provide(Payment p) {
        return "Wallet debit: " + p.amount;
    }
}