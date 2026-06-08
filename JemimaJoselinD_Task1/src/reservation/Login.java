package reservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JLabel titleLabel, userLabel, passLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton, clearButton;

    public Login() {

        setTitle("Online Reservation System - Login");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        titleLabel = new JLabel("ONLINE RESERVATION SYSTEM");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(60, 20, 350, 30);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(70, 80, 100, 30);

        usernameField = new JTextField();
        usernameField.setBounds(170, 80, 180, 30);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(70, 130, 100, 30);

        passwordField = new JPasswordField();
        passwordField.setBounds(170, 130, 180, 30);

        loginButton = new JButton("Login");
        loginButton.setBounds(90, 200, 100, 35);

        clearButton = new JButton("Clear");
        clearButton.setBounds(230, 200, 100, 35);

        loginButton.addActionListener(this);

        clearButton.addActionListener(e -> {
            usernameField.setText("");
            passwordField.setText("");
        });

        add(titleLabel);
        add(userLabel);
        add(usernameField);
        add(passLabel);
        add(passwordField);
        add(loginButton);
        add(clearButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());

        // Demo Login Credentials
        if (username.equals("admin") &&
                password.equals("admin123")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Login Successful"
            );

            dispose();

            new Reservation();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Username or Password"
            );

        }
    }

    public static void main(String[] args) {

        new Login();

    }
}