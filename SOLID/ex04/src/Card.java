public class Card implements ProvidingCompany {
    @Override
    public String provide(Payment p) {
        return "Charged card: " + p.amount;
    }
}