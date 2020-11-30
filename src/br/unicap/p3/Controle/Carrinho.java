package br.unicap.p3.Controle;


import br.unicap.p3.Exceptions.ListaVaziaException;
import br.unicap.p3.Exceptions.ProdutosException;
import br.unicap.p3.Exceptions.QuantidadeIndisponivelException;
import br.unicap.p3.Exceptions.ValorNaoEncontradoException;
import br.unicap.p3.Exceptions.ValorRepetidoException;
import br.unicap.p3.Model.GerenciarLista;
import br.unicap.p3.Model.LSESemRepetidos;
import br.unicap.p3.Model.Produto;

public class Carrinho{
    private LSESemRepetidos<Produto> listacarrinho;
    private FachadaControle FC = FachadaControle.getObjeto();;
    private double TotalPreco;
    private int QtdCompras;

    public Carrinho() {
    	GerenciarLista <Produto> GL = new GerenciarLista <Produto> ();
        listacarrinho = GL.CriarLista();
    }

    public void AdicionarNoCarrinho(String cod, int qtd) throws ProdutosException,QuantidadeIndisponivelException, ValorRepetidoException {
        Produto p,result;
        p = new Produto(cod);
        result = FC.ObterProduto(cod);
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

    public void CofirmarCompra() throws ProdutosException{
        Produto result = null;
        for (int i = 0; i < this.QtdCompras; i++) {
            try {
				result = listacarrinho.EnviarObjeto();
			} catch (ListaVaziaException e) {
				e.printStackTrace();
			}
            if (result == null) {
            	throw new ProdutosException();
            }
            else {
            	FC.AdicionarPedido(result);
            }
        }
        this.QtdCompras = 0;
    }

    public void ExcluirCompra(String cod) throws ProdutosException, ListaVaziaException{
        Produto p,resultC,resultP;
        p = new Produto(cod);
        resultP = FC.ObterProduto(cod);
        resultC = listacarrinho.BuscarObjeto(p);
        if (resultP == null || resultC == null) {
        	throw new ProdutosException();
        }
        else {
        	resultP.setEstoque(resultP.getEstoque() + resultC.getEstoque());
            try {
				listacarrinho.Remover(p);
			} catch (ValorNaoEncontradoException e) {
				e.printStackTrace();
			}
            this.QtdCompras--;
        }
    }
}