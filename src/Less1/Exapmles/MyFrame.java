package Less1.Exapmles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * В этом классе мы работаем с созданием окона и выводим кнопку "нажми меня" В окне.
 */

public class MyFrame extends JFrame {
    public MyFrame() {
        JButton button = new JButton("Нажми меня");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Код, который будет выполнен при нажатии кнопки
                System.out.println("Кнопка была нажата");
            }
        });

        add(button);

        setTitle("Мое окно");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
