package br.unicap.p3.View;

import java.util.Scanner;

import br.unicap.p3.Controle.AcessoCliente;
import br.unicap.p3.Controle.Carrinho;
import br.unicap.p3.Controle.GerenciarProdutos;
import br.unicap.p3.Controle.ListaPedidos;
import br.unicap.p3.Exceptions.ListaVaziaException;
import br.unicap.p3.Exceptions.ProdutosException;
import br.unicap.p3.Exceptions.QuantidadeIndisponivelException;
import br.unicap.p3.Exceptions.SenhaCPFException;
import br.unicap.p3.Exceptions.ValorRepetidoException;

public class AreaCliente {
    public static void Login() {
        Scanner input = new Scanner(System.in);
        int Opcao;
        AcessoCliente Cliente = new AcessoCliente();
        do {
            Menus.MenuLogin();
            Opcao = input.nextInt();
            switch (Opcao) {
                case 1:
				try {
					Cliente.Login();
				} catch (ProdutosException | QuantidadeIndisponivelException | SenhaCPFException
						| ValorRepetidoException | ListaVaziaException e) {
					e.printStackTrace();
				}
                    break;
                case 2:
				try {
					Cliente.Cadastro();
				} catch (ValorRepetidoException e) {
					e.printStackTrace();
				}
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Valor inválido!");
            }
        } while (Opcao != 0);
    }

    public static void AreadoCliente() throws ProdutosException, QuantidadeIndisponivelException, ValorRepetidoException, ListaVaziaException {
        Scanner input = new Scanner(System.in);
        int Opcao, op, qtd;
        String codigo;
        GerenciarProdutos GP = new GerenciarProdutos();
        Carrinho C = new Carrinho();
        do {
            Menus.MenuCliente();
            Opcao = input.nextInt();input.nextLine();
            switch (Opcao) {
                case 1:
                    do {
                        GP.Catalogo();
                        System.out.println("Digite o código do produto que deseja comprar: ");
                        codigo = input.nextLine();
                        System.out.println("Digite a quantidade: ");
                        qtd = input.nextInt();input.nextLine();
                        C.AdicionarNoCarrinho(codigo, qtd);
                        System.out.println("Deseja comprar outro produto?");
                        System.out.println("1 - SIM / 0 - NÃO");
                        op = input.nextInt();
                    } while (op != 0);
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
                    System.out.println("Valor invï¿½lido!");
            }
        } while (Opcao != 0);
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
                    System.out.println("opï¿½ï¿½o incorreta");
                    break;
            }
        } while (op != 0);
    }

    public static void ControleCarrinho() throws ProdutosException, ListaVaziaException {
        Scanner in = new Scanner(System.in);
        Carrinho lista = new Carrinho();
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
                    System.out.print("Insira o codigo do produto que deseja retirar do Carrinho: ");
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
                    System.out.println("opï¿½ï¿½o incorreta");
                    break;
            }
        } while (op != 0);
    }
}