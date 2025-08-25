// Deprecated broad interface; replaced by EnginePowered, PedalPowered, Rechargeable
@Deprecated
interface Vehicle {
    void startEngine();
    void pedal(int effort);
    void recharge(int kWh);
}