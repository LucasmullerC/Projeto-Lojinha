package br.unicap.p3.Carrinho;

import br.unicap.p3.Dados.*;
import br.unicap.p3.Vendedor.*;
import br.unicap.p3.Produto.ProdutoP3;
import br.unicap.p3.Pedidos.RegistrarPedido;

public class ListaCarrinho {

    private LSESemRepetidos<Carrinho> listacarrinho;
    private double TotalPreco;
    private int QtdCompras;

    public ListaCarrinho() {
        listacarrinho = new LSESemRepetidos<Carrinho>();
    }

    public void AdicionarNoCarrinho(String cod, int qtd) {
        Funcionario f = new Funcionario();
        double preco;
        Carrinho c;
        c = new Carrinho(cod);
        preco = f.ObterPreco(cod);
        c.setPreco(preco);
        c.setQtd(qtd);
        this.TotalPreco = this.TotalPreco + preco;
        listacarrinho.inserirNoFinal(c);
        this.QtdCompras++;
        System.out.println("O produto foi adicionardo ao Carrinho!");
    }

    public void ExibirCarrinho() {
        listacarrinho.exibirTodos();
    }

    public double ExibirTotalPreco() {
        return this.TotalPreco;
    }

    public void CofirmarCompra() {
        RegistrarPedido regis  = new RegistrarPedido();
        Carrinho c;
        for (int i = 0; i < this.QtdCompras; i++) {
            c = listacarrinho.EnviarObjeto();
           regis.RegistrarPedido(c);
        }
        this.QtdCompras = 0;
    }

    public void ExcluirCompra(String cod) {
        Carrinho c;
        c = new Carrinho(cod);
        listacarrinho.removerNo(c);
        this.QtdCompras--;
    }

}
