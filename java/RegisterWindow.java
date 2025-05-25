import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class RegisterWindow extends JFrame {
    public RegisterWindow() {
        setTitle("Register Car Owner");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel plateLabel = new JLabel("Plate Number:");
        JTextField plateField = new JTextField(20);

        JLabel nameLabel = new JLabel("Owner Name:");
        JTextField nameField = new JTextField(20);

        JLabel addressLabel = new JLabel("Address:");
        JTextField addressField = new JTextField(20);

        JButton registerBtn = new JButton("Register");
        JButton backBtn = new JButton("Back");

        registerBtn.addActionListener(e -> {
            String plate = plateField.getText();
            String name = nameField.getText();
            String address = addressField.getText();

            if (!plate.isEmpty() && !name.isEmpty() && !address.isEmpty()) {
                CarOwner owner = new CarOwner(plate, name, address);
                DatabaseManager db = new DatabaseManager();
                if (db.registerCarOwner(owner)) {
                    JOptionPane.showMessageDialog(this, "Registration successful!");
                    plateField.setText("");
                    nameField.setText("");
                    addressField.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to register.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "All fields are required.");
            }
        });

        backBtn.addActionListener(e -> {
            new MainWindow();
            dispose();
        });

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        formPanel.add(plateLabel);
        formPanel.add(plateField);
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(addressLabel);
        formPanel.add(addressField);
        formPanel.add(registerBtn);
        formPanel.add(backBtn);

        add(formPanel);
        setVisible(true);
    }
}