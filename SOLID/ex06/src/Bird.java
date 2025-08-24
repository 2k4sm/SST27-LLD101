public class Bird implements AbstractBird, Flyable {
    @Override
    public void fly() {
        System.out.println("Flap!");
    }

    @Override
    public void makeSound() {
        System.out.println("Chirp!");
    }
}
