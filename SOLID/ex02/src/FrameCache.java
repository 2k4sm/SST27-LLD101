public class FrameCache implements Cache {
    private Frame lastFrame;

    @Override
    public void store(Frame frame) {
        this.lastFrame = frame;
        System.out.println("Cached last frame? " + (lastFrame != null));
    }

    @Override
    public Frame getLastFrame() {
        return lastFrame;
    }
}
