package Less1.Exapmles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExUser1 {
    private JFrame frame;
    private JTextArea chatArea;
    private JTextField messageField;
    private ExUser2 exUser2;

    public ExUser1(ExUser2 exUser2) {
        this.exUser2 = exUser2;

        frame = new JFrame("User1");
        chatArea = new JTextArea();
        messageField = new JTextField(10);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText();
                showMessage("User1: " + message);
                if (exUser2 != null) {
                    exUser2.showMessage("User1: " + message);
                }
                messageField.setText("");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(messageField);
        buttonPanel.add(sendButton);

        frame.setLayout(new BorderLayout());
        frame.add(chatArea, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void showMessage(String message) {
        chatArea.append(message + "\n");
    }

    public void setUser2(ExUser2 exUser2) {
        this.exUser2 = exUser2;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ExUser1 exUser1 = new ExUser1(null);
                ExUser2 exUser2 = new ExUser2(exUser1);
                exUser1.setUser2(exUser2);
            }
        });
    }
}