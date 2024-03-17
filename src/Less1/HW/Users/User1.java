package Less1.HW.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class User1 {
    private JFrame frame;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JTextArea chatArea;
    private JTextField messageField;

    public static void main(String[] args) {
        // Создаем объект класса User1
        User1 User1 = new User1();
    }

    public User1() {
        // Создаем главное окно
        frame = new JFrame("User1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Создаем поля аутентификации
        loginField = new JTextField("User1");
        passwordField = new JPasswordField();

        // Создаем поле чата
        chatArea = new JTextArea();
        chatArea.setEditable(false);

        // Создаем поле для написания сообщений
        messageField = new JTextField();
        messageField.setEnabled(false);

        // Добавляем слушатель клавиш для отправки сообщений
        KeyListener messageFieldKeyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        messageField.addKeyListener(messageFieldKeyListener);

        // Создаем кнопку для аутентификации
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticate();
            }
        });

        // Создаем кнопку для отправки сообщений
        JButton messageButton = new JButton("Send");
        messageButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText();
                showMessage(message);
                messageField.setText("");
                sendMessage();
            }
        });
        messageButton.setEnabled(false);

        // Добавляем компоненты на главное окно
        frame.setLayout(new BorderLayout());
        JPanel loginPanel = new JPanel(new GridLayout(2, 2));
        loginPanel.add(new JLabel("Login: "));
        loginPanel.add(loginField);
        loginPanel.add(new JLabel("Password: "));
        loginPanel.add(passwordField);
        frame.add(loginPanel, BorderLayout.NORTH);
        frame.add(chatArea, BorderLayout.CENTER);
        JPanel messagePanel = new JPanel(new BorderLayout());
        messagePanel.add(messageField, BorderLayout.CENTER);
        messagePanel.add(messageButton, BorderLayout.EAST);
        frame.add(messagePanel, BorderLayout.SOUTH);
        frame.add(loginButton, BorderLayout.EAST);

        // Отображаем окно
        frame.setVisible(true);
    }

    private void authenticate() {
        String login = loginField.getText();
        String password = new String(passwordField.getPassword());

        // Проверяем правильность аутентификации
        if (login.equals("User1") && password.equals("1234")) {
            // В случае успешной аутентификации
            showMessage("Connected to server.");
            // Включаем поле для написания сообщений и кнопку отправки
            messageField.setEnabled(true);
            frame.getRootPane().setDefaultButton(null);
        } else {
            // В случае неправильного логина или пароля
            showMessage("Authentication failed.");
        }
    }

    private void sendMessage() {
        String message = messageField.getText().trim();
        if (!message.isEmpty()) {
            // Отправляем сообщение в чат
            showMessage("User1: " + message);

            // Отправляем сообщение на сервер
            sendToServer("User1: " + message);

            // Очищаем поле ввода сообщения
            messageField.setText("");
        }
    }

    // Метод для отправки сообщения на сервер (пока просто выводим сообщение в консоль)
    private void sendToServer(String message) {
        System.out.println("Message sent to server: " + message);
    }

    private void showMessage(String message) {
        chatArea.append("User1: " + message + "\n");
        chatArea.append(message + "\n");
        chatArea.setCaretPosition(chatArea.getDocument().getLength());
    }
}
