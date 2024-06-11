import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TelaPagamento extends JFrame {
    private Carrinho carrinho;

    public TelaPagamento(Carrinho carrinho) {
        this.carrinho = carrinho;

        setTitle("Pagamento");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal com padding
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel title = new JLabel("Pagamento", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title, BorderLayout.NORTH);

        // Painel de campos de pagamento
        JPanel fieldsPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        fieldsPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel totalLabel = new JLabel("Total: R$ " + carrinho.getTotal(), SwingConstants.RIGHT);
        totalLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        fieldsPanel.add(totalLabel);
        fieldsPanel.add(new JLabel()); // Placeholder

        JLabel nameLabel = new JLabel("Nome no Cartão:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField nameText = new JTextField();
        nameText.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel cardLabel = new JLabel("Número do Cartão:");
        cardLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField cardText = new JTextField();
        cardText.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel expiryLabel = new JLabel("Validade:");
        expiryLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField expiryText = new JTextField();
        expiryText.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel cvvLabel = new JLabel("CVV:");
        cvvLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField cvvText = new JTextField();
        cvvText.setFont(new Font("Arial", Font.PLAIN, 16));

        fieldsPanel.add(nameLabel);
        fieldsPanel.add(nameText);
        fieldsPanel.add(cardLabel);
        fieldsPanel.add(cardText);
        fieldsPanel.add(expiryLabel);
        fieldsPanel.add(expiryText);
        fieldsPanel.add(cvvLabel);
        fieldsPanel.add(cvvText);

        panel.add(fieldsPanel, BorderLayout.CENTER);

        // Botão de finalização de compra
        JButton finalizarButton = new JButton("Finalizar Compra");
        finalizarButton.setFont(new Font("Arial", Font.PLAIN, 16));
        finalizarButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Compra finalizada com sucesso!");
            dispose();
        });

        panel.add(finalizarButton, BorderLayout.SOUTH);

        add(panel);
    }
}
