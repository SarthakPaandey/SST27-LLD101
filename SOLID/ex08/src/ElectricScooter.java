public class ElectricScooter implements EnginePowered, Rechargeable {
    private int battery = 0;
    public void startEngine(){ System.out.println("Scooter motor engaged; battery="+battery+"kWh"); }
    public void recharge(int kWh){ battery += kWh; System.out.println("Scooter recharged to "+battery+"kWh"); }
}


