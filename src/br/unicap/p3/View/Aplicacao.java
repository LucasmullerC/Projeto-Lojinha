package br.unicap.p3.View;
import java.util.Scanner;

import br.unicap.p3.Controle.Gerente;
import br.unicap.p3.Exceptions.ListaVaziaException;
import br.unicap.p3.Exceptions.ProdutosException;
import br.unicap.p3.Exceptions.QuantidadeIndisponivelException;
import br.unicap.p3.Exceptions.SenhaCPFException;
import br.unicap.p3.Exceptions.ValorRepetidoException;
public class Aplicacao {
	public static void main(String[] args){
		Scanner input = new Scanner (System.in);
		int Opcao;
		FachadaView FV = FachadaView.getObjeto();
		do {
			Menus.MenuInicio();
			Opcao = input.nextInt();input.nextLine();
			switch (Opcao) {
			case 1:
				FV.LoginCliente();
				break;
			case 2:
				try {
					FV.LoginVendedor();
				} catch (ProdutosException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					FV.LoginGerente();
				} catch (ListaVaziaException | ValorRepetidoException e) {
					e.printStackTrace();
				}
				break;	
			case 0:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Valor incorreto.");
			}
		}while (Opcao != 0);

	}

}
