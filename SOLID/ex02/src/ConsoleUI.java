public class ConsoleUI implements UI {
    @Override
    public void showPlayStatus(int fileSize) {
        System.out.println("\u25B6 Playing " + fileSize + " bytes");
    }
}
