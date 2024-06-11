import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TelaPrincipal extends JFrame {
    private Carrinho carrinho;
    private List<Produto> produtos;

    public TelaPrincipal(Carrinho carrinho) {
        this.carrinho = carrinho;
        this.produtos = criarProdutos();

        setTitle("Vitrine de Produtos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal com padding
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Tabela de produtos com título
        JLabel title = new JLabel("Vitrine de Produtos", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title, BorderLayout.NORTH);

        // Painel de produtos
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));

        for (Produto produto : produtos) {
            JPanel productRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel productLabel = new JLabel(produto.toString());
            productLabel.setFont(new Font("Arial", Font.PLAIN, 16));

            JTextField quantityField = new JTextField(3);
            quantityField.setFont(new Font("Arial", Font.PLAIN, 16));

            JButton addButton = new JButton("Adicionar");
            addButton.setFont(new Font("Arial", Font.PLAIN, 16));
            addButton.addActionListener(e -> {
                try {
                    int quantidade = Integer.parseInt(quantityField.getText());
                    carrinho.adicionarProduto(produto, quantidade);
                    JOptionPane.showMessageDialog(this, "Produto adicionado ao carrinho!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Quantidade inválida!");
                }
            });

            productRow.add(productLabel);
            productRow.add(new JLabel("Quantidade:"));
            productRow.add(quantityField);
            productRow.add(addButton);

            productPanel.add(productRow);
        }

        JScrollPane scrollPane = new JScrollPane(productPanel);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Painel de navegação
        JPanel navPanel = new JPanel(new FlowLayout());
        navPanel.setBorder(new EmptyBorder(10, 0, 0, 0));

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 16));
        loginButton.addActionListener(e -> {
            new TelaLogin(carrinho).setVisible(true);
            dispose();
        });

        JButton cartButton = new JButton("Carrinho");
        cartButton.setFont(new Font("Arial", Font.PLAIN, 16));
        cartButton.addActionListener(e -> {
            new TelaCarrinho(carrinho).setVisible(true);
            dispose();
        });

        navPanel.add(loginButton);
        navPanel.add(cartButton);
        panel.add(navPanel, BorderLayout.SOUTH);

        add(panel);
    }

    private List<Produto> criarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Produto 1", 100.00));
        produtos.add(new Produto("Produto 2", 200.00));
        produtos.add(new Produto("Produto 3", 300.00));
        return produtos;
    }

    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();
        TelaPrincipal telaPrincipal = new TelaPrincipal(carrinho);
        telaPrincipal.setVisible(true);
    }
}

