package br.unicap.p3.View;

import br.unicap.p3.Controle.Funcionario;
import br.unicap.p3.Controle.GerenciarProdutos;
import br.unicap.p3.Exceptions.ProdutosException;
import br.unicap.p3.Exceptions.SenhaCPFException;

import java.util.Scanner;

public class AreaVendedor {

    public static void Login() throws ProdutosException {
        Scanner input = new Scanner(System.in);
        int Opcao;
        Funcionario F = new Funcionario();
        do {
            Menus.MenuLoginVendedor();
            Opcao = input.nextInt();
            switch (Opcao) {
                case 1:
				try {
					F.LoginFuncionario();
				} catch (SenhaCPFException e) {
					e.printStackTrace();
				}
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Valor inv�lido!");
            }
        } while (Opcao != 0);
    }

    public static void AreadoVendedor() throws ProdutosException {
        Scanner input = new Scanner(System.in);
        int Opcao;
        GerenciarProdutos GP = new GerenciarProdutos();
        do {
            Menus.MenuVendedor();
            Opcao = input.nextInt();
            switch (Opcao) {
                case 1:
                    GP.CadastrarProduto();
                    break;
                case 2:
                    GP.RemoverProduto();
                    break;
                case 3:
                    GP.AlterarProduto();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Valor inv�lido!");
            }
        } while (Opcao != 0);
    }
}