public class Demo08 {
    public static void main(String[] args) {
        // Pedal-powered vehicle
        PedalPowered bike = new Bicycle();
        bike.pedal(5);

        // Engine-powered vehicle
        EnginePowered moto = new Motorbike();
        moto.startEngine();

        // Electric vehicle
        ElectricScooter scooter = new ElectricScooter();
        scooter.recharge(5);
        scooter.startEngine();
    
}
