package br.unicap.p3.Carrinho;

import br.unicap.p3.Dados.*;
import br.unicap.p3.Pedidos.ListaPedidos;
import br.unicap.p3.Produto.Produto;
import br.unicap.p3.Produto.GerenciarProdutos;

public class Carrinho{
    private LSESemRepetidos<Produto> listacarrinho;
    private ListaPedidos lista = new ListaPedidos();
    private double TotalPreco;
    private int QtdCompras;

    public Carrinho() {
        listacarrinho = new LSESemRepetidos<Produto>();
    }

    public void AdicionarNoCarrinho(String cod, int qtd) {
        GerenciarProdutos gp = new GerenciarProdutos();
        Produto p,result;
        p = new Produto(cod);
        result = gp.ObterProduto(cod);
        if(result.getEstoque() < qtd){
            System.out.println("Quantidade indisponível no estoque!");
        }
        else{
            result.setEstoque(result.getEstoque() - qtd);
            p.setPreco(result.getPreco());
            p.setNome(result.getNome());
            p.setEstoque(qtd);
            this.TotalPreco = this.TotalPreco + result.getPreco();
            listacarrinho.inserirOrdenado(p);
            this.QtdCompras++;
            System.out.println("O produto foi adicionardo ao Carrinho!");
        }
    }

    public void ExibirCarrinho() {
        listacarrinho.exibirTodos();
    }

    public double ExibirTotalPreco() {
        return this.TotalPreco;
    }

    public void CofirmarCompra() {
        Produto result;
        for (int i = 0; i < this.QtdCompras; i++) {
            result = listacarrinho.EnviarObjeto();
            lista.AdicionarPedido(result);
        }
        this.QtdCompras = 0;
    }

    public void ExcluirCompra(String cod) {
        GerenciarProdutos gp = new GerenciarProdutos();
        Produto p,resultC,resultP;
        p = new Produto(cod);
        resultP = gp.ObterProduto(cod);
        resultC = listacarrinho.BuscarObjeto(p);
        resultP.setEstoque(resultP.getEstoque() + resultC.getEstoque());
        listacarrinho.Remover(p);
        this.QtdCompras--;
    }
}