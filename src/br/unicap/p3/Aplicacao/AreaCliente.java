package br.unicap.p3.Aplicacao;
import java.util.Scanner;

import br.unicap.p3.Carrinho.ListaCarrinho;
import br.unicap.p3.Cliente.AcessoCliente;
import br.unicap.p3.Pedidos.ListaPedidos;
import br.unicap.p3.Vendedor.Funcionario;
public class AreaCliente {
	public static void Login () {
		Scanner input = new Scanner (System.in);
		int Opcao;
		AcessoCliente Cliente = new AcessoCliente();
		do {
			Menus.MenuLogin();
			Opcao = input.nextInt();
			switch (Opcao) {
			case 1:
				Cliente.Login();
				break;
			case 2:
				Cliente.Cadastro();
				break;
			case 0:
				break;
			default:
				System.out.println("Valor inválido!");
			}
		}while (Opcao != 0);
	}
	public static void AreadoCliente() {
		Scanner input = new Scanner (System.in);
		int Opcao,op,qtd;
		String codigo;
		Funcionario F = new Funcionario();
		ListaCarrinho C = new ListaCarrinho();
		do {
			Menus.MenuCliente();
			Opcao = input.nextInt();
			switch (Opcao) {
			case 1:
				do {
					F.Catalogo();
					System.out.println("Digite o código do produto que deseja comprar: ");
					codigo = input.nextLine();
					System.out.println("Digite a quantidade: ");
					qtd = input.nextInt();
					C.AdicionarNoCarrinho(codigo,qtd);
					System.out.println("Deseja comprar outro produto?");
					System.out.println("1 - SIM / 0 - NÃO");
					op = input.nextInt();
				}while (op != 0);
				break;
			case 2:
				ControleCarrinho();
				break;
			case 3:
				ControlePedido();
				break;
			case 0:
				break;
			default:
				System.out.println("Valor inválido!");
			}
		}while (Opcao != 0);
	}
	public static void ControlePedido() {
		ListaPedidos lista = new ListaPedidos();
        Scanner in = new Scanner(System.in);
        int op;
        do {
            Menus.MenuPedidos();
            op = in.nextInt();
            in.nextLine();
            switch (op) {
                case 1:
                    lista.HistoricoPedidos();
                    break;
                case 0:
                    System.out.println("Voltar");
                    break;
                default:
                    System.out.println("opção incorreta");
                    break;
            }
        } while (op != 0);
	}
	 public static void ControleCarrinho(){
	        Scanner in = new Scanner(System.in);
	        ListaCarrinho lista = new ListaCarrinho();
	        int op;
	        double total;
	        do {
	            Menus.MenuCarrinho();
	            op = in.nextInt();
	            in.nextLine();
	            switch (op) {
	                case 1:
	                    lista.ExibirCarrinho();
	                    break;
	                case 2:
	                    total = lista.ExibirTotalPreco();
	                    System.out.println("R$: " + total);
	                    break;
	                case 3:
	                    System.out.println("Insira o codigo do produto que deseja retirar do Carrinho:");
	                    String cod = in.nextLine();
	                    lista.ExcluirCompra(cod);
	                    break;
	                case 4:
	                    lista.CofirmarCompra();
	                    break;
	                case 0:
	                    System.out.println("Voltar");
	                    break;
	                default:
	                    System.out.println("opção incorreta");
	                    break;
	            }
	        } while (op != 0);
	    }

}
