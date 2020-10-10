package br.unicap.p3.Aplicacao;
import java.util.Scanner;
import br.unicap.p3.Gerente.Gerente;
public class Aplicacao {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		int Opcao;
		AreaVendedor AV = new AreaVendedor();
		Gerente G = new Gerente();
		do {
			Menus.MenuInicio();
			Opcao = input.nextInt();
			switch (Opcao) {
			case 1:
				AreaCliente.Login();
				break;
			case 2:
				AV.Login();
				break;
			case 3:
				G.LoginGerente();
				break;						
			}
		}while (Opcao != 0);

	}

}
