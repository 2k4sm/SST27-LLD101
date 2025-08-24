public class Car implements Movable, EngineVehicle {
    @Override
    public void move() {
        System.out.println("Car is moving with engine power");
    }

    @Override
    public void startEngine() {
        System.out.println("Engine started: Vroom!");
    }
}
