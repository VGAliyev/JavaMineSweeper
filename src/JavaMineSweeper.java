import javax.swing.*;
import java.awt.*;

public class JavaMineSweeper extends JFrame {
    private JPanel panel;

    public static void main(String[] args) {

        new JavaMineSweeper();
    }

    private JavaMineSweeper() {
        initPanel();
        initFrame();
    }

    private void initPanel() {
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 500));
        add(panel);
    }

    private void initFrame() {
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Mine Sweeper");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}