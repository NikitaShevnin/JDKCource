package Less1.Exapmles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExUser2 {
    private JFrame frame;
    private JTextArea chatArea;
    private JTextField messageField;
    private ExUser1 exUser1;

    public ExUser2(ExUser1 exUser1) {
        this.exUser1 = exUser1;

        frame = new JFrame("User2");
        chatArea = new JTextArea();
        messageField = new JTextField(10);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText();
                showMessage("User2: " + message);
                if (exUser1 != null) {
                    exUser1.showMessage("User2: " + message);
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

    public void setUser1 (ExUser1 exUser1) {
        this.exUser1 = exUser1;
    }

    public void showMessage(String message) {
        chatArea.append(message + "\n");
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
