import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Map;

public class TelaCarrinho extends JFrame {
    private Carrinho carrinho;

    public TelaCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;

        setTitle("Carrinho de Compras");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal com padding
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel title = new JLabel("Carrinho de Compras", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title, BorderLayout.NORTH);

        // Painel de itens no carrinho
        JPanel cartPanel = new JPanel();
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));

        for (Map.Entry<Produto, Integer> entry : carrinho.getItens().entrySet()) {
            Produto produto = entry.getKey();
            int quantidade = entry.getValue();

            JLabel itemLabel = new JLabel(produto.getNome() + " - Quantidade: " + quantidade + " - Preço: R$ " + produto.getPreco() * quantidade);
            itemLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            cartPanel.add(itemLabel);
        }

        JScrollPane scrollPane = new JScrollPane(cartPanel);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Painel de navegação
        JPanel navPanel = new JPanel(new FlowLayout());
        navPanel.setBorder(new EmptyBorder(10, 0, 0, 0));

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setFont(new Font("Arial", Font.PLAIN, 16));
        checkoutButton.addActionListener(e -> {
            new TelaPagamento(carrinho).setVisible(true);
            dispose();
        });

        JButton backButton = new JButton("Voltar");
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.addActionListener(e -> {
            new TelaPrincipal(carrinho).setVisible(true);
            dispose();
        });

        navPanel.add(backButton);
        navPanel.add(checkoutButton);
        panel.add(navPanel, BorderLayout.SOUTH);

        add(panel);
    }
}
