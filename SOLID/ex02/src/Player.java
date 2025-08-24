public class Player {
    private final Decoder decoder;
    private final UI ui;
    private final Cache cache;

    public Player(Decoder decoder, UI ui, Cache cache) {
        this.decoder = decoder;
        this.ui = ui;
        this.cache = cache;
    }

    public void play(byte[] fileBytes) {
        // decode
        Frame frame = decoder.decode(fileBytes);

        // draw UI
        ui.showPlayStatus(fileBytes.length);

        // cache
        cache.store(frame);
    }
}
