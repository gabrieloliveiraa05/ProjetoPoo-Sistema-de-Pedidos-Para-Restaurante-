package projetoPoo;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Calculavel {
    private String nomeCliente;
    private List<ItemMenu> itens;

    public Pedido(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemMenu item) {
        this.itens.add(item);
    }

    public List<ItemMenu> getItens() {
        return this.itens;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    @Override
    public double calcularTotal() {
        double total = 0.0;
        for (ItemMenu item : itens) {
            total += item.calcularTotal();
        }
        return total;
    }
}
