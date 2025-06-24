// Login.java
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Login extends JFrame {
    public Login() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5));

        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(new JLabel());
        add(loginButton);

        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            try (Connection conn = Database.connect()) {
                String query = "SELECT * FROM users WHERE email = ? AND password = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, email);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    int userId = rs.getInt("id");
                    dispose();
                    new Main();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}