package Less1.HW.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Server {
    private JFrame frame;
    private JTextArea chatArea;
    private JButton startButton;
    private JButton stopButton;
    private boolean serverRunning = false;

    public static void main(String[] args) {
        // Создаем объект класса Server
        Server Server = new Server();
    }

    public Server() {
        // Создаем главное окно
        frame = new JFrame("Server");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Создаем поле чата
        chatArea = new JTextArea();
        chatArea.setEditable(false);

        // Создаем кнопки
        startButton = new JButton("Start Server");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startServer();
            }
        });

        stopButton = new JButton("Stop Server");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopServer();
            }
        });

        // Добавляем компоненты на главное окно
        frame.setLayout(new BorderLayout());
        frame.add(chatArea, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Отображаем окно
        frame.setVisible(true);
    }

    public static void receiveMessage(String message) {
        System.out.println("Received Message: " + message);
    }

    private void startServer() {
        if (!serverRunning) {
            serverRunning = true;
            showMessage("Server is running...");
        }
    }

    private void stopServer() {
        if (serverRunning) {
            serverRunning = false;
            showMessage("Server stopped.");
        }
    }

    private void showMessage(String message) {
        chatArea.setText(chatArea.getText() + message + "\n");
    }
}
