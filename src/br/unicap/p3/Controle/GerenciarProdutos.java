package br.unicap.p3.Controle;

import br.unicap.p3.Exceptions.ListaVaziaException;
import br.unicap.p3.Exceptions.ProdutosException;
import br.unicap.p3.Exceptions.ValorNaoEncontradoException;
import br.unicap.p3.Exceptions.ValorRepetidoException;
import br.unicap.p3.Model.GerenciarLista;
import br.unicap.p3.Model.PessoaGeral;
import br.unicap.p3.Model.Produto;
import br.unicap.p3.View.Menus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class GerenciarProdutos {
    private ArrayList<Produto> gerenciar;
    int Code;

    public GerenciarProdutos() {
        GerenciarLista <Produto> GL = new GerenciarLista <Produto> ();
        gerenciar = GL.CriarLista();
    }

    public Produto ObterProduto(int cod) {
        Produto aux;
        aux = gerenciar.get(cod);
        return aux;
    }

    public void Catalogo() {
    	Iterator iterator = gerenciar.iterator();
    	while (iterator.hasNext()) {
    		Produto obj = (Produto) iterator.next();
    		System.out.println(obj);
    	}
    }

    public void RemoverProduto() {
        Scanner input = new Scanner(System.in);
        int Codigo;
        System.out.println("Digite o cï¿½digo do produto: ");
        Codigo = input.nextInt();
        gerenciar.remove(Codigo);
        System.out.println("Produto removido!");
    }

    public void AlterarProduto() throws ProdutosException{
        Scanner input = new Scanner(System.in);
        int op, qtd;
        int Codigo;
        double preco;
        Produto Result;
        System.out.println("Digite o cï¿½digo do produto que deseja alterar: ");
        Codigo = input.nextInt();
        Result = gerenciar.get(Codigo);
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
        int qtd;
        String Nome;
        double preco;
        Produto P;
        System.out.println("Digite o nome do produto: ");
        Nome = input.nextLine();
        Code++;
        System.out.println("Digite o preï¿½o do produto: ");
        preco = input.nextDouble();
        System.out.println("Digite a quantidade: ");
        qtd = input.nextInt();
        P = new Produto(Code);
        P.setNome(Nome);
        P.setPreco(preco);
        P.setEstoque(qtd);
        System.out.println("O código do produto é " +Code);
        gerenciar.add(P);
        Carrinho.setList(gerenciar);
    }
}