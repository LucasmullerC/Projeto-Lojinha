package br.unicap.p3.Aplicacao;

import java.util.Scanner;

import br.unicap.p3.Vendedor.Funcionario;

public class AreaVendedor {
	public static void Login () {
		Scanner input = new Scanner (System.in);
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
				System.out.println("Valor inválido!");
			}
		}while (Opcao != 0);
	}
	public static void AreadoVendedor () {
		Scanner input = new Scanner (System.in);
		int Opcao;
		Funcionario F = new Funcionario();
		do {
			Menus.MenuVendedor();
			Opcao = input.nextInt();
			switch (Opcao) {
			case 1:
				F.CadastrarProduto();
				break;
			case 2:
				F.RemoverProduto();
				break;
			case 3:
				F.AlterarProduto();
				break;
			case 0:
				break;
			default:
				System.out.println("Valor inválido!");
			}
		}while (Opcao != 0);
	}

}
