public class Aviary {
    public void release(AbstractBird bird) {
        bird.makeSound();

        if (bird instanceof Flyable) {
            ((Flyable) bird).fly();
            System.out.println("Released into the sky");
        } else if (bird instanceof Swimmer) {
            ((Swimmer) bird).swim();
            System.out.println("Released into the water");
        } else {
            System.out.println("Released on the ground");
        }
    }
}
