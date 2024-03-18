package Less2.HW.server;

public class MainServerWindow {
    public static void main(String[] args) {
        ServerWindowGUI gui = new ServerWindowGUI();
        ServerWindowRepository repository = new ServerWindowRepository();
        ServerWindowController controller = new ServerWindowController(gui, repository);
    }
}
