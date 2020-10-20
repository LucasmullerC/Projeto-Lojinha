package br.unicap.p3.Cliente;

import java.util.Scanner;

import br.unicap.p3.Aplicacao.AreaCliente;
import br.unicap.p3.Aplicacao.Menus;
import br.unicap.p3.Dados.*;
import br.unicap.p3.Exceptions.CPFInvalidoCaracterException;
import br.unicap.p3.Exceptions.CPFInvalidoNumException;
import br.unicap.p3.Exceptions.ListaVaziaException;
import br.unicap.p3.Exceptions.ProdutosException;
import br.unicap.p3.Exceptions.QuantidadeIndisponivelException;
import br.unicap.p3.Exceptions.SenhaCPFException;
import br.unicap.p3.Exceptions.ValorRepetidoException;

public class AcessoCliente {
	LSESemRepetidos<PessoaGeral> ListaCliente = new LSESemRepetidos();
	Cliente C;
	ClienteEspecial CE,Result;
	boolean TipoCliente;
	String CPF, Senha;

	public void Cadastro() throws ValorRepetidoException {
		Scanner input = new Scanner(System.in);
		int op;
		boolean vef = false;
		do {
			System.out.print("Digite o seu CPF: ");
			CPF = input.nextLine();
			try {
				vef = VerificarCPF.VerificarConta(CPF);
			} catch (CPFInvalidoCaracterException | CPFInvalidoNumException e) {
				e.printStackTrace();
			}
		} while (vef == false);
		System.out.print("Digite a sua senha: ");
		Senha = input.nextLine();
		Menus.MenuEspecial();
		op = input.nextInt();
		if (op == 1) {
			CE = new ClienteEspecial(CPF);
			CE.setSenha(Senha);
			ListaCliente.inserirNoFinal(CE);
			TipoCliente = true;
		} else {
			C = new Cliente(CPF);
			C.setSenha(Senha);
			ListaCliente.inserirNoFinal(C);
			TipoCliente = false;
		}
		System.out.println("Cadastro efetuado com sucesso!");
	}

	public void Login() throws ProdutosException, QuantidadeIndisponivelException, SenhaCPFException,
			ValorRepetidoException, ListaVaziaException {
		Scanner input = new Scanner(System.in);
		Cliente Vef = null;
		ClienteEspecial VefS;
		int op;
		boolean vefC = false;
		do {
			System.out.print("Digite o seu CPF: ");
			CPF = input.nextLine();
			try {
				vefC = VerificarCPF.VerificarConta(CPF);
			} catch (CPFInvalidoCaracterException | CPFInvalidoNumException e) {
				e.printStackTrace();
			}
		} while (vefC == false);
		System.out.print("Digite a sua senha: ");
		Senha = input.nextLine();
		Menus.MenuEspecialLogin();
		op = input.nextInt();
		if (op == 1) {
			CE = new ClienteEspecial(CPF);
			CE.setSenha(Senha);
			VefS =(ClienteEspecial) ListaCliente.BuscarObjeto(CE);
			TipoCliente = true;
			if (VefS.getSenha().equals(Senha) && VefS != null) {
				System.out.println("Login efetuado com sucesso");
				AreaCliente.AreadoCliente();
			} else {
				throw new SenhaCPFException();
			}
		} else {
			C = new Cliente(CPF);
			C.setSenha(Senha);
			Vef = (Cliente) ListaCliente.BuscarObjeto(C);
			TipoCliente = false;
			if (Vef.getSenha().equals(Senha) && Vef != null) {
				System.out.println("Login efetuado com sucesso");
				AreaCliente.AreadoCliente();
			} else {
				throw new SenhaCPFException();
			}
		}
	}
	public boolean VerificaCliente () {
		return TipoCliente;
	}
	public void AdicionaPonto () {
		CE.setCpf(CPF);
		Result = (ClienteEspecial) ListaCliente.BuscarObjeto(CE);
		Result.setPontos(1 + Result.getPontos());
	}
	
	
}
