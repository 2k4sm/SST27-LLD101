public class ElectricBike implements Movable, Pedalable, Rechargeable {
    @Override
    public void move() {
        System.out.println("Electric bike is moving with pedal assist");
    }

    @Override
    public void pedal(int effort) {
        System.out.println("Pedal effort " + effort + " with electric assistance");
    }

    @Override
    public void recharge(int kWh) {
        System.out.println("Recharging electric bike battery with " + kWh + " kWh");
    }
}
