package br.unicap.p3.Gerente;

import java.util.Scanner;

import br.unicap.p3.Aplicacao.Menus;
import br.unicap.p3.Cliente.PessoaGeral;
import br.unicap.p3.Dados.LSESemRepetidos;
import br.unicap.p3.Dados.VerificarCPF;
import br.unicap.p3.Exceptions.CPFInvalidoCaracterException;
import br.unicap.p3.Exceptions.CPFInvalidoNumException;
import br.unicap.p3.Exceptions.ListaVaziaException;
import br.unicap.p3.Exceptions.ValorNaoEncontradoException;
import br.unicap.p3.Exceptions.ValorRepetidoException;
import br.unicap.p3.Vendedor.Vendedor;

public class SubGerente {
	protected LSESemRepetidos<PessoaGeral> gerenciar;

	public SubGerente() {
		gerenciar = new LSESemRepetidos<PessoaGeral>();
	}

	public void LoginSubGerente() throws ListaVaziaException, ValorRepetidoException {
		Scanner input = new Scanner(System.in);
		int senha;
		System.out.println("Digite a sua senha: ");
		senha = input.nextInt();
		while (senha != 321) {
			System.out.println("Senha incorreta,digite novamente: ");
			senha = input.nextInt();
		}
		int op;
		do {
			Menus.MenuSubGerente();
			System.out.println("Informe a op��oo: ");
			op = input.nextInt();
			input.nextLine();
			switch (op) {
			case 1:
				Contratar();
				break;
			case 2:
				exibirVendedores();

				break;

			case 0:
				System.out.println(" ");
				break;
			default:
				System.out.println("Opção inválida!");
			}
		} while (op != 0);
	}

	public void Contratar() throws ValorRepetidoException {
		Scanner input = new Scanner(System.in);
		Vendedor v;
		String cpf, senha;
		System.out.println("Digite o CPF do novo funcionário: ");
		cpf = input.nextLine();
		System.out.println("Informe A senha: ");
		senha = input.nextLine();
		v = new Vendedor(cpf);
		v.setSenha(senha);
		gerenciar.inserirNoFinal(v);
		System.out.println("Vendedor contratado!");
	}

	public Vendedor BuscaVendedor(Vendedor v) {
		Vendedor Vef;

		Vef = (Vendedor) gerenciar.BuscarObjeto(v);
		return Vef;
	}

	public void exibirVendedores() {
		gerenciar.exibirTodos();
	}

}
