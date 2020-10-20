package br.unicap.p3.Produto;
public class ProdutoRaro extends Produto{
	public ProdutoRaro(String C) {
		super(C);
	}
	double p;
	public void PrecoR () {
		this.setPreco(this.getPreco() * 1.25);
	}
	

}
