package br.unicap.p3.Controle;


import java.util.ArrayList;
import java.util.Iterator;

import br.unicap.p3.Exceptions.ListaVaziaException;
import br.unicap.p3.Exceptions.ProdutosException;
import br.unicap.p3.Exceptions.QuantidadeIndisponivelException;
import br.unicap.p3.Exceptions.ValorNaoEncontradoException;
import br.unicap.p3.Exceptions.ValorRepetidoException;
import br.unicap.p3.Model.GerenciarLista;
import br.unicap.p3.Model.PessoaGeral;
import br.unicap.p3.Model.Produto;

public class Carrinho{
    private ArrayList<Produto> listacarrinho;
    private FachadaControle FC = FachadaControle.getObjeto();;
    private static ArrayList<Produto> gerenciar = getList();
    private double TotalPreco;
    private int QtdCompras;

    public Carrinho() {
    	GerenciarLista <Produto> GL = new GerenciarLista <Produto> ();
        listacarrinho = GL.CriarLista();
    }

    public void AdicionarNoCarrinho(int cod, int qtd) throws ProdutosException,QuantidadeIndisponivelException, ValorRepetidoException {
        Produto p,result;
        p = new Produto(cod);
        result = gerenciar.get(cod);
        if (result == null) {
        	throw new ProdutosException();
        }
        if(result.getEstoque() < qtd){
            throw new QuantidadeIndisponivelException();
        }
        else{
            result.setEstoque(result.getEstoque() - qtd);
            p.setPreco(result.getPreco());
            p.setNome(result.getNome());
            p.setEstoque(qtd);
            this.TotalPreco = this.TotalPreco + result.getPreco();
            listacarrinho.add(p);
            this.QtdCompras++;
            System.out.println("O produto foi adicionardo ao Carrinho!");
        }
    }
    public static void setList (ArrayList<Produto> arrayList) {
    	gerenciar = arrayList;
    }
    public static ArrayList<Produto> getList() {
        return gerenciar;
    }

    public void ExibirCarrinho() {
    	Iterator iterator = listacarrinho.iterator();
    	while (iterator.hasNext()) {
    		Produto obj = (Produto) iterator.next();
    		System.out.println(obj);
    	}
    }

    public double ExibirTotalPreco() {
        return this.TotalPreco;
    }

    public void CofirmarCompra() throws ProdutosException{
        Produto result = null;
        for (int i = 0; i < this.QtdCompras; i++) {
            result = listacarrinho.get(i);
            if (result == null) {
            	throw new ProdutosException();
            }
            else {
            	FC.AdicionarPedido(result);
            }
        }
        for (int i = 0; i < this.QtdCompras; i++) {
        	listacarrinho.remove(i);
        }
        this.QtdCompras = 0;
    }

    public void ExcluirCompra(int cod) throws ProdutosException, ListaVaziaException{
    	if (cod > listacarrinho.size()) {
    		System.out.println("Código não é válido!");
    	}
    	else {
    		Produto resultC,resultP;
            resultP = gerenciar.get(cod);
            resultC = listacarrinho.get(cod);
            if (resultP == null || resultC == null) {
            	throw new ProdutosException();
            }
            else {
            	resultP.setEstoque(resultP.getEstoque() + resultC.getEstoque());
                listacarrinho.remove(cod);
                this.QtdCompras--;
            }
        }
    	}
}