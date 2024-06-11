public class Main {
    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();
        TelaPrincipal telaPrincipal = new TelaPrincipal(carrinho);
        telaPrincipal.setVisible(true);
    }
}
