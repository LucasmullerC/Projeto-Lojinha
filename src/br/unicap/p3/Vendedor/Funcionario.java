package br.unicap.p3.Vendedor;

import java.util.Scanner;

import br.unicap.p3.Aplicacao.AreaCliente;
import br.unicap.p3.Aplicacao.AreaVendedor;
import br.unicap.p3.Aplicacao.Menus;
import br.unicap.p3.Cliente.Cliente;
import br.unicap.p3.Dados.LSESemRepetidos;
import br.unicap.p3.Dados.ListadoProduto;
import br.unicap.p3.Dados.VerificarCPF;
import br.unicap.p3.Gerente.Gerente;
import br.unicap.p3.Produto.ProdutoP3;

public class Funcionario {
	private ListadoProduto<ProdutoP3> gerenciar;

	public Funcionario() {
		gerenciar = new ListadoProduto<ProdutoP3>();
	}

	public double ObterPreco(String cod) {
		double preco;
		ProdutoP3 p, aux;
		p = new ProdutoP3(cod);
		aux = gerenciar.AlterarValor(p);
//Expetion Aqui
		preco = aux.getPreco();
		return preco;
	}

	public void Catalogo() {
		gerenciar.ExibirTodos();
	}

	public void LoginFuncionario() {
		Scanner input = new Scanner(System.in);
		AreaVendedor AV = new AreaVendedor();
		Gerente G = new Gerente();
		Vendedor v;
		Vendedor Vef;
		String CPF;
		String Senha;
		boolean vefC;
		input.nextLine();
		do {
			System.out.print("Digite o seu CPF: ");
			CPF = input.nextLine();
			vefC = VerificarCPF.VerificarConta(CPF);
		}while (vefC == false);
		System.out.print("Digite a sua senha: ");
		Senha = input.nextLine();
		Vef = G.BuscaVendedor(CPF);
		System.out.println(Vef.getSenha());
		if (Vef.getSenha().compareTo(Senha) == 0 && Vef != null) {	
			System.out.print("Login efetuado com sucesso");
			AV.AreadoVendedor();
		}
		else {
			System.out.print("Senha ou CPF inválido");
		}	
	}
	public void RemoverProduto() {
		Scanner input = new Scanner (System.in);
		String Codigo;
		ProdutoP3 P;
		ListadoProduto LP = new ListadoProduto();
		System.out.println("Digite o código do produto: ");
		Codigo = input.nextLine();
		P = new ProdutoP3(Codigo);
		LP.Remover(P);
		System.out.println("Produto removido!");
	}
	public void AlterarProduto () {
		Scanner input = new Scanner (System.in);
		int op,qtd;
		String Nome,Codigo;
		double preco;
		ProdutoP3 P, Result;
		ListadoProduto LP = new ListadoProduto();
		System.out.println("Digite o código do produto que deseja alterar: ");
		Codigo = input.nextLine();
		P = new ProdutoP3(Codigo);
		Result =(ProdutoP3) LP.AlterarValor(P);
		if (Result == null) {
			System.out.println("Produto não encontrado");
		}
		else {
			Menus.MenuAlterarProduto();
			op = input.nextInt();
			switch(op) {
			case 1:
				System.out.println("Digite o novo preço: ");
				preco = input.nextDouble();
				Result.setPreco(preco);
				System.out.println("Produto alterado! ");
				break;
			case 2:
				System.out.println("Digite o novo Estoque: ");
				qtd = input.nextInt();
				Result.setEstoque(qtd);
				System.out.println("Produto alterado! ");
				break;
			case 3:
				System.out.println("Digite o novo preço: ");
				preco = input.nextDouble();
				Result.setPreco(preco);
				System.out.println("Digite o novo Estoque: ");
				qtd = input.nextInt();
				Result.setEstoque(qtd);
				System.out.println("Produto alterado! ");
				break;
			default:
				System.out.println("Valor inválido.");
			}
				
		}
	}

	public void CadastrarProduto() {
		Scanner input = new Scanner (System.in);
		int op,qtd;
		String Nome,Codigo;
		double preco;
		ProdutoP3 P, Result;
		ListadoProduto LP = new ListadoProduto();
		System.out.println("Digite o nome do produto: ");
		Nome = input.nextLine();
		System.out.println("Digite o código do produto: ");
		Codigo = input.nextLine();
		System.out.println("Digite o preço do produto: ");
		preco = input.nextDouble();
		System.out.println("Digite a quantidade: ");
		qtd = input.nextInt();
		P = new ProdutoP3(Codigo);
		P.setNome(Nome);
		P.setPreco(preco);
		P.setEstoque(qtd);
		LP.Cadastrar(P);
	}
}
