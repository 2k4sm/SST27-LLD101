public class Demo02 {
    public static void main(String[] args) {
        Decoder decoder = new StandardDecoder();
        UI ui = new ConsoleUI();
        Cache cache = new FrameCache();
        Player player = new Player(decoder, ui, cache);

        player.play(new byte[] { 1, 2, 3, 4 });
    }
}
