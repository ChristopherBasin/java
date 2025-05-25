import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        setTitle("Victor's Subdivision Car Template Scanner");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Victor's Subdivision Car Template Scanner", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton scanButton = new JButton("Scan");
        JButton registerButton = new JButton("Register");

        scanButton.addActionListener(e -> {
            new ScanWindow();
            dispose();
        });

        registerButton.addActionListener(e -> {
            new RegisterWindow();
            dispose();
        });

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        buttonPanel.add(scanButton);
        buttonPanel.add(registerButton);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(buttonPanel);

        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}