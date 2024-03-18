package Less2.HW.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindowController {
    private ServerWindowGUI gui;
    private ServerWindowRepository repository;

    public ServerWindowController(ServerWindowGUI gui, ServerWindowRepository repository) {
        this.gui = gui;
        this.repository = repository;

        gui.addStartButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (repository.isWork()) {
                    gui.appendLog("Сервер уже был запущен");
                } else {
                    repository.startServer();
                    gui.appendLog("Сервер запущен!");
                }
            }
        });

        gui.addStopButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!repository.isWork()) {
                    gui.appendLog("Сервер уже был остановлен");
                } else {
                    repository.stopServer();
                    gui.appendLog("Сервер остановлен!");
                }
            }
        });
    }
}
