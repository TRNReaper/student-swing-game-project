import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private PlayerService playerService;

    public LoginFrame() {
        playerService = new PlayerService();

        // Basic GUI layout initialization
        setTitle("Game Project Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Username:", SwingConstants.CENTER));
        txtUsername = new JTextField();
        add(txtUsername);

        add(new JLabel("Password:", SwingConstants.CENTER));
        txtPassword = new JPasswordField();
        add(txtPassword);

        add(new JLabel("")); // Empty spacer
        btnLogin = new JButton("Login");
        add(btnLogin);

        // Completed action listener for Login
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                Player player = playerService.login(username, password);

                if (player != null) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Login successful!");
                    MainMenuFrame menuFrame = new MainMenuFrame(player);
                    menuFrame.setVisible(true);
                    dispose(); // Close login window
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password!", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
