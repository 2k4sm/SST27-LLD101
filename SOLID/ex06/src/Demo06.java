public class Demo06 {
    public static void main(String[] args) {
        Aviary aviary = new Aviary();

        // Release a flying bird
        aviary.release(new Bird());

        // Release a swimming bird (no more runtime error)
        aviary.release(new Penguin());
    }
}
