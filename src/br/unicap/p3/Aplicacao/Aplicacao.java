package br.unicap.p3.Aplicacao;
import java.util.Scanner;

import br.unicap.p3.Exceptions.ListaVaziaException;
import br.unicap.p3.Exceptions.ProdutosException;
import br.unicap.p3.Exceptions.QuantidadeIndisponivelException;
import br.unicap.p3.Exceptions.SenhaCPFException;
import br.unicap.p3.Exceptions.ValorRepetidoException;
import br.unicap.p3.Gerente.Gerente;
import br.unicap.p3.Gerente.SubGerente;
public class Aplicacao {
	public static void main(String[] args){
		Scanner input = new Scanner (System.in);
		int Opcao;
		AreaVendedor AV = new AreaVendedor();
		Gerente G = new Gerente();
		SubGerente SG = new SubGerente();
		do {
			Menus.MenuInicio();
			Opcao = input.nextInt();input.nextLine();
			switch (Opcao) {
			case 1:
				AreaCliente.Login();
				break;
			case 2:
				try {
					AV.Login();
				} catch (ProdutosException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					G.LoginGerente();
				} catch (ListaVaziaException | ValorRepetidoException e) {
					e.printStackTrace();
				}
				break;	
			case 4:
				try {
					SG.LoginSubGerente();
				} catch (ListaVaziaException | ValorRepetidoException e) {
					e.printStackTrace();
				}
			case 0:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Valor incorreto.");
			}
		}while (Opcao != 0);

	}

}
