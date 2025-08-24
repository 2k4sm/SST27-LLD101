public class Penguin implements AbstractBird, Swimmer {
    @Override
    public void makeSound() {
        System.out.println("Squawk!");
    }

    @Override
    public void swim() {
        System.out.println("Swimming gracefully!");
    }
}
