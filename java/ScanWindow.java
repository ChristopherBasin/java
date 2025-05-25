import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class ScanWindow extends JFrame {
    public ScanWindow() {
        setTitle("Scan Car Plate");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel plateLabel = new JLabel("Enter Plate Number:");
        JTextField plateField = new JTextField(20);
        JButton scanBtn = new JButton("Scan");
        JButton backBtn = new JButton("Back");

        scanBtn.addActionListener(e -> {
            String plate = plateField.getText();
            if (!plate.isEmpty()) {
                DatabaseManager db = new DatabaseManager();
                CarOwner owner = db.findCarByPlate(plate);
                if (owner != null) {
                    JOptionPane.showMessageDialog(this, "Car Found:\n" + owner);
                } else {
                    JOptionPane.showMessageDialog(this, "Car not registered!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a plate number.");
            }
        });

        backBtn.addActionListener(e -> {
            new MainWindow();
            dispose();
        });

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(plateLabel);
        panel.add(plateField);
        panel.add(scanBtn);
        panel.add(backBtn);
        add(panel);
        setVisible(true);
    }
}