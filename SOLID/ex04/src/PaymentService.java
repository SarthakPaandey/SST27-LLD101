public class PaymentService {
    ProvidingCompany providingCompany;
    public PaymentService(ProvidingCompany providingCompany) {
        this.providingCompany = providingCompany;
    }
    String pay(Payment p){
        return providingCompany.provide(p);
    }
}
// switch (p.provider) {

//             case "CARD": return "Charged card: " + p.amount;
//             case "UPI":  return "Paid via UPI: " + p.amount;
//             case "WALLET": return "Wallet debit: " + p.amount;
//             default: throw new RuntimeException("No provider");
//         }