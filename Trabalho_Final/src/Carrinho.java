import java.util.HashMap;
import java.util.Map;

public class Carrinho {
    private Map<Produto, Integer> itens;

    public Carrinho() {
        itens = new HashMap<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        itens.put(produto, itens.getOrDefault(produto, 0) + quantidade);
    }

    public Map<Produto, Integer> getItens() {
        return itens;
    }

    public double getTotal() {
        double total = 0;
        for (Map.Entry<Produto, Integer> entry : itens.entrySet()) {
            total += entry.getKey().getPreco() * entry.getValue();
        }
        return total;
    }
}
