package br.unicap.p3.Produto;

import br.unicap.p3.Aplicacao.Menus;
import br.unicap.p3.Dados.LSESemRepetidos;
import br.unicap.p3.Exceptions.ListaVaziaException;
import br.unicap.p3.Exceptions.ProdutosException;
import br.unicap.p3.Exceptions.ValorNaoEncontradoException;
import br.unicap.p3.Exceptions.ValorRepetidoException;

import java.util.Scanner;

public class GerenciarProdutos {
	private LSESemRepetidos<Produto> gerenciar;

	public GerenciarProdutos() {
		gerenciar = new LSESemRepetidos<Produto>();
	}

	public Produto ObterProduto(String cod) {
		Produto p, aux;
		p = new Produto(cod);
		aux = gerenciar.BuscarObjeto(p);
		return aux;
	}

	public void Catalogo() {
		gerenciar.exibirTodos();
	}

	public void RemoverProduto() {
		Scanner input = new Scanner(System.in);
		String Codigo;
		Produto P;
		System.out.println("Digite o cï¿½digo do produto: ");
		Codigo = input.nextLine();
		P = new Produto(Codigo);
		try {
			gerenciar.Remover(P);
		} catch (ListaVaziaException e) {
			e.printStackTrace();
		} catch (ValorNaoEncontradoException e) {
			e.printStackTrace();
		}
		System.out.println("Produto removido!");
	}

	public void AlterarProduto() throws ProdutosException {
		Scanner input = new Scanner(System.in);
		int op, qtd;
		String Codigo;
		double preco;
		Produto P, Result;
		LSESemRepetidos LP = new LSESemRepetidos();
		System.out.println("Digite o cï¿½digo do produto que deseja alterar: ");
		Codigo = input.nextLine();
		P = new Produto(Codigo);
		Result = gerenciar.BuscarObjeto(P);
		if (Result == null) {
			throw new ProdutosException();
		} else {
			Menus.MenuAlterarProduto();
			op = input.nextInt();
			switch (op) {
			case 1:
				System.out.println("Digite o novo preï¿½o: ");
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
				System.out.println("Digite o novo preï¿½o: ");
				preco = input.nextDouble();
				Result.setPreco(preco);
				System.out.println("Digite o novo Estoque: ");
				qtd = input.nextInt();
				Result.setEstoque(qtd);
				System.out.println("Produto alterado! ");
				break;
			default:
				System.out.println("Valor invï¿½lido.");
			}
		}
	}

	public void CadastrarProduto() {
		Scanner input = new Scanner(System.in);
		int qtd, op;
		String Nome, Codigo,data;
		double preco;
		Produto P;
		ProdutoRaro PR;
		ProdutoPerecivel PP;
		System.out.println("Digite o nome do produto: ");
		Nome = input.nextLine();
		System.out.println("Digite o cï¿½digo do produto: ");
		Codigo = input.nextLine();
		System.out.println("Digite o preï¿½o do produto: ");
		preco = input.nextDouble();
		System.out.println("Digite a quantidade: ");
		qtd = input.nextInt();
		Menus.MenuProdutoRaro();
		op = input.nextInt();
		switch (op) {
		case 1:
			PR = new ProdutoRaro(Codigo);
			PR.setNome(Nome);
			PR.setPreco(preco);
			PR.setEstoque(qtd);
			PR.PrecoR();
			try {
				gerenciar.inserirOrdenado(PR);
			} catch (ValorRepetidoException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			P = new Produto(Codigo);
			P.setNome(Nome);
			P.setPreco(preco);
			P.setEstoque(qtd);
			try {
				gerenciar.inserirOrdenado(P);
			} catch (ValorRepetidoException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			PP = new ProdutoPerecivel(Codigo);
			System.out.println("Digite a data de valídade do produto:");
			data = input.nextLine();
			PP.setData(data);
			PP.setNome(Nome);
			PP.setPreco(preco);
			PP.setEstoque(qtd);	
			try {
				gerenciar.inserirOrdenado(PP);
			} catch (ValorRepetidoException e) {
				e.printStackTrace();
			}
			break;
			
		}
	}
}