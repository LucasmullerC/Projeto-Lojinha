package br.unicap.p3.Cliente;
import java.util.Scanner;
import br.unicap.p3.Dados.*;
public class AcessoCliente {
	LSESemRepetidos <Cliente> ListaCliente = new LSESemRepetidos();
	Cliente C;
	public void Cadastro () {
		Scanner input = new Scanner (System.in);
		String CPF,Senha;
		boolean vef;
		do {
			System.out.print("Digite o seu CPF: ");
			CPF = input.nextLine();
			vef = VerificarCPF.VerificarConta(CPF);
		}while (vef == false);
		System.out.print("Digite a sua senha: ");
		Senha = input.nextLine();
		C = new Cliente(CPF);
		C.setSenha(Senha);
		ListaCliente.inserirNoFinal(C);
	}
	public void Login () {
		Scanner input = new Scanner (System.in);
		String CPF,Senha;
		Cliente Vef;
		boolean vefC;
		do {
			System.out.print("Digite o seu CPF: ");
			CPF = input.nextLine();
			vefC = VerificarCPF.VerificarConta(CPF);
		}while (vefC == false);
		System.out.print("Digite a sua senha: ");
		Senha = input.nextLine();
		C = new Cliente(CPF);
		Vef = ListaCliente.BuscarObjeto(C);
		if (Vef.getSenha().equals(Senha) && Vef != null) {	
			System.out.print("Login efetuado com sucesso");
		}
		else {
			System.out.print("Senha ou CPF inválido");
		}	
	}	
}
