public class EmailClient implements NotificationService{
    public void send(String to, String body) {
        System.out.println("[EMAIL to=" + to + "] " + body);
    }
}