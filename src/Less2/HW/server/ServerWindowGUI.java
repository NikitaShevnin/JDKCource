package Less2.HW.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ServerWindowGUI extends JFrame {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    JTextArea log;
    JButton btnStart, btnStop;

    public ServerWindowGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
    }

    public String getLog() {
        return log.getText();
    }

    public void appendLog(String text) {
        log.append(text + "\n");
    }

    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }

    public void addStartButtonListener(ActionListener listener) {
        btnStart.addActionListener(listener);
    }

    public void addStopButtonListener(ActionListener listener) {
        btnStop.addActionListener(listener);
    }

}
