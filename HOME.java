import javax.swing.*;
import java.awt.*;

public class HOME extends JFrame {
    public HOME() {
        setTitle("Home");
        setSize(300, 125);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1, 5, 5));

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        loginButton.addActionListener(e -> {
            dispose();
            new Login();
        });

        registerButton.addActionListener(e -> {
            dispose();
            new Register();
        });

        add(loginButton);
        add(registerButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Database.initialize();
        new HOME();
    }
}
