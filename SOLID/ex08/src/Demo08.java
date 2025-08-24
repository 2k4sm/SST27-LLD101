public class Demo08 {
    public static void main(String[] args) {
        // Using segregated interfaces - no more crashes
        Bicycle bicycle = new Bicycle();
        bicycle.move();
        bicycle.pedal(5);

        Car car = new Car();
        car.move();
        car.startEngine();

        ElectricBike eBike = new ElectricBike();
        eBike.move();
        eBike.pedal(3);
        eBike.recharge(10);
    }
}
