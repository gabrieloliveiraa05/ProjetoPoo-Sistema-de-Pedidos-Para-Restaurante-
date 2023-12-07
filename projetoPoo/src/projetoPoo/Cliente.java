package projetoPoo;
public class Cliente {
	
 
	public static void main(String[] args) {
     System.out.println("Olá! Qual é o seu nome?");
     java.util.Scanner scanner = new java.util.Scanner(System.in);
     String nomeCliente = scanner.nextLine();

     GerarPedido geradorPedido = new GerarPedido();
     geradorPedido.realizarPedido(nomeCliente);

     System.out.println("Obrigado, " + nomeCliente + ", por visitar o restaurante!");
     scanner.close();
 }
}
