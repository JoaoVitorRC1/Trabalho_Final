import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TelaLogin extends JFrame {
    private Carrinho carrinho;

    public TelaLogin(Carrinho carrinho) {
        this.carrinho = carrinho;

        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal com padding
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel title = new JLabel("Login", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title, BorderLayout.NORTH);

        // Painel de campos de login
        JPanel fieldsPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        fieldsPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel userLabel = new JLabel("Usuário:");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField userText = new JTextField();
        userText.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel passLabel = new JLabel("Senha:");
        passLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JPasswordField passText = new JPasswordField();
        passText.setFont(new Font("Arial", Font.PLAIN, 16));

        fieldsPanel.add(userLabel);
        fieldsPanel.add(userText);
        fieldsPanel.add(passLabel);
        fieldsPanel.add(passText);

        panel.add(fieldsPanel, BorderLayout.CENTER);

        // Botão de login
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 16));
        loginButton.addActionListener(e -> {
            String usuario = userText.getText();
            String senha = new String(passText.getPassword());

            if (usuario.equals("admin") && senha.equals("admin")) {
                JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
                new TelaPrincipal(carrinho).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos!");
            }
        });

        panel.add(loginButton, BorderLayout.SOUTH);

        add(panel);
    }
}
