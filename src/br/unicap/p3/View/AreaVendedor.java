package br.unicap.p3.View;

import br.unicap.p3.Controle.FachadaControle;
import br.unicap.p3.Controle.Funcionario;
import br.unicap.p3.Controle.GerenciarProdutos;
import br.unicap.p3.Exceptions.ProdutosException;
import br.unicap.p3.Exceptions.SenhaCPFException;

import java.util.Scanner;

public class AreaVendedor {
	
	private FachadaControle FC = FachadaControle.getObjeto();
    public void Login() throws ProdutosException {
        Scanner input = new Scanner(System.in);
        int Opcao;
        do {
            Menus.MenuLoginVendedor();
            Opcao = input.nextInt();
            switch (Opcao) {
                case 1:
				try {
					FC.LoginFuncionario();
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

    public void AreadoVendedor() throws ProdutosException {
        Scanner input = new Scanner(System.in);
        int Opcao;
        do {
            Menus.MenuVendedor();
            Opcao = input.nextInt();
            switch (Opcao) {
                case 1:
                    FC.CadastrarProduto();
                    break;
                case 2:
                    FC.RemoverProduto();
                    break;
                case 3:
                    FC.AlterarProduto();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Valor inv�lido!");
            }
        } while (Opcao != 0);
    }
}