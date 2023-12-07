package projetoPoo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GerarPedido {
    private List<Pedido> pedidos;

    public GerarPedido() {
        this.pedidos = new ArrayList<>();
    }

    public static int gerarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(1000);
    }

    public void realizarPedido(String nomeCliente) {
        PratoPrincipal lasanha = new PratoPrincipal("Lasanha", 30.99);
        PratoPrincipal sushi = new PratoPrincipal("Sushi", 35.99);
        PratoPrincipal feijoada = new PratoPrincipal("Feijoada", 25.99);

        Bebida refrigerante = new Bebida("Refrigerante", 5.99);
        Bebida suco = new Bebida("Suco", 4.99);
        Bebida cerveja = new Bebida("Cerveja", 7.99);

        exibirOpcoes("Escolha seu prato principal:", lasanha, sushi, feijoada);
        int escolhaPrato = solicitarEscolha();

        exibirOpcoes("Escolha sua bebida:", refrigerante, suco, cerveja);
        int escolhaBebida = solicitarEscolha();

        double totalPedido = calcularTotal(escolhaPrato, escolhaBebida);

        int escolhaPagamento = solicitarEscolhaFormaPagamento();

        System.out.println("Deseja confirmar o pedido com pagamento " + obterFormaPagamento(escolhaPagamento) + "? (S/N)");
        Scanner scanner = new Scanner(System.in);
        String confirmacao = scanner.next();

        if (confirmacao.equalsIgnoreCase("S")) {
            int numeroPedido = gerarNumeroAleatorio();
            System.out.println("Pedido confirmado! Número do pedido: " + numeroPedido);

            Pedido novoPedido = new Pedido(nomeCliente);
            adicionarItensAoPedido(novoPedido, escolhaPrato, escolhaBebida);
            this.pedidos.add(novoPedido);
            System.out.println("Deseja fazer outro pedido? (S/N)");
            String fazerOutroPedido = scanner.next();
            if (fazerOutroPedido.equalsIgnoreCase("S")) {
                realizarPedido(nomeCliente);
            } else {
                exibirPedidosRealizados();
                System.out.println("Programa encerrado.");
            }
        } else {
            System.out.println("Pedido não confirmado.");
        }
    }

    private void adicionarItensAoPedido(Pedido pedido, int escolhaPrato, int escolhaBebida) {
        PratoPrincipal[] pratos = {
                new PratoPrincipal("Lasanha", 30.99),
                new PratoPrincipal("Sushi", 35.99),
                new PratoPrincipal("Feijoada", 25.99)
        };

        Bebida[] bebidas = {
                new Bebida("Refrigerante", 5.99),
                new Bebida("Suco", 4.99),
                new Bebida("Cerveja", 7.99)
        };

        if (escolhaPrato >= 1 && escolhaPrato <= pratos.length) {
            pedido.adicionarItem(pratos[escolhaPrato - 1]);
        }

        if (escolhaBebida >= 1 && escolhaBebida <= bebidas.length) {
            pedido.adicionarItem(bebidas[escolhaBebida - 1]);
        }
    }

    private double calcularTotal(int escolhaPrato, int escolhaBebida) {
        return 0.0;
    }

    private void exibirOpcoes(String mensagem, ItemMenu... opcoes) {
        System.out.println(mensagem);
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println((i + 1) + ". " + opcoes[i].getNome() + " - R$" + opcoes[i].getPreco());
        }
    }

    private int solicitarEscolha() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma opção:");
        return scanner.nextInt();
    }

    private int solicitarEscolhaFormaPagamento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha a forma de pagamento (1. Pix, 2. Cartão, 3. Dinheiro):");
        return scanner.nextInt();
    }

    private String obterFormaPagamento(int escolha) {
        switch (escolha) {
            case 1:
                return "Pix";
            case 2:
                return "Cartão";
            case 3:
                return "Dinheiro";
            default:
                return "Desconhecido";
        }
    }

    private void exibirPedidosRealizados() {
        System.out.println("Pedidos realizados:");
        for (Pedido pedido : pedidos) {
            System.out.println("Cliente: " + pedido.getNomeCliente());
            System.out.println("Total do pedido: R$" + pedido.calcularTotal());
            System.out.println("---");
        }
    }

    public static void main(String[] args) {
        GerarPedido geradorPedido = new GerarPedido();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        geradorPedido.realizarPedido(nomeCliente);

        scanner.close();
    }
}



