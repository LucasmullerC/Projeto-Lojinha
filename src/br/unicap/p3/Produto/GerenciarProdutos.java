package br.unicap.p3.Produto;

import br.unicap.p3.Aplicacao.Menus;
import br.unicap.p3.Dados.LSESemRepetidos;
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
        //Expetion Aqui
        return aux;
    }

    public void Catalogo() {
        gerenciar.exibirTodos();
    }

    public void RemoverProduto() {
        Scanner input = new Scanner(System.in);
        String Codigo;
        Produto P;
        System.out.println("Digite o c�digo do produto: ");
        Codigo = input.nextLine();
        P = new Produto(Codigo);
        gerenciar.Remover(P);
        System.out.println("Produto removido!");
    }

    public void AlterarProduto() {
        Scanner input = new Scanner(System.in);
        int op, qtd;
        String Codigo;
        double preco;
        Produto P, Result;
        LSESemRepetidos LP = new LSESemRepetidos();
        System.out.println("Digite o c�digo do produto que deseja alterar: ");
        Codigo = input.nextLine();
        P = new Produto(Codigo);
        Result = gerenciar.BuscarObjeto(P);
        if (Result == null) {
            System.out.println("Produto n�o encontrado");
        } else {
            Menus.MenuAlterarProduto();
            op = input.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Digite o novo pre�o: ");
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
                    System.out.println("Digite o novo pre�o: ");
                    preco = input.nextDouble();
                    Result.setPreco(preco);
                    System.out.println("Digite o novo Estoque: ");
                    qtd = input.nextInt();
                    Result.setEstoque(qtd);
                    System.out.println("Produto alterado! ");
                    break;
                default:
                    System.out.println("Valor inv�lido.");
            }
        }
    }

    public void CadastrarProduto() {
        Scanner input = new Scanner(System.in);
        int qtd;
        String Nome, Codigo;
        double preco;
        Produto P;
        System.out.println("Digite o nome do produto: ");
        Nome = input.nextLine();
        System.out.println("Digite o c�digo do produto: ");
        Codigo = input.nextLine();
        System.out.println("Digite o pre�o do produto: ");
        preco = input.nextDouble();
        System.out.println("Digite a quantidade: ");
        qtd = input.nextInt();
        P = new Produto(Codigo);
        P.setNome(Nome);
        P.setPreco(preco);
        P.setEstoque(qtd);
        gerenciar.inserirOrdenado(P);
    }
}