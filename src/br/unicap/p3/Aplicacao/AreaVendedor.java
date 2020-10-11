package br.unicap.p3.Aplicacao;

import br.unicap.p3.Produto.GerenciarProdutos;
import java.util.Scanner;

import br.unicap.p3.Vendedor.Funcionario;

public class AreaVendedor {

    public static void Login() {
        Scanner input = new Scanner(System.in);
        int Opcao;
        Funcionario F = new Funcionario();
        do {
            Menus.MenuLoginVendedor();
            Opcao = input.nextInt();
            switch (Opcao) {
                case 1:
                    F.LoginFuncionario();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Valor inv�lido!");
            }
        } while (Opcao != 0);
    }

    public static void AreadoVendedor() {
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