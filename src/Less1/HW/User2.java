package Less1.HW;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class User2 {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 1234;

    public static void main(String[] args) {
        JFrame frame = new JFrame("User2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField();
        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = textField.getText();
                sendMessage(message, chatArea);
                textField.setText("");
            }
        });

        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String message = textField.getText();
                    sendMessage(message, chatArea);
                    textField.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(textField, BorderLayout.NORTH);
        frame.getContentPane().add(new JScrollPane(chatArea), BorderLayout.CENTER);
        frame.getContentPane().add(sendButton, BorderLayout.SOUTH);

        frame.setSize(400, 300);
        frame.setVisible(true);

        initializeChatLog(chatArea);

        try {
            Socket clientSocket = new Socket(SERVER_IP, SERVER_PORT);
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            Thread receiveThread = new Thread(() -> {
                try {
                    InputStream inputStream = clientSocket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                    String message;
                    while ((message = reader.readLine()) != null) {
                        appendToChatArea(chatArea, message);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

            receiveThread.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void initializeChatLog(JTextArea chatArea) {
        try {
            File file = new File("chatlog.txt");
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    appendToChatArea(chatArea, line);
                }

                bufferedReader.close();
                fileReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendMessage(String message, JTextArea chatArea) {
        appendToChatArea(chatArea, "User2: " + message);
        try {
            Socket clientSocket = new Socket(SERVER_IP, SERVER_PORT);
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            writer.println("User2: " + message);
            writer.close();
            clientSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void appendToChatArea(JTextArea chatArea, String line) {
        chatArea.append(line + "\n");
        chatArea.setCaretPosition(chatArea.getDocument().getLength());
    }
}
