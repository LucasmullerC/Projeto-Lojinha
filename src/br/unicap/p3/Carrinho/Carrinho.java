package br.unicap.p3.Carrinho;

public class Carrinho implements Comparable<Carrinho>{
	private String Codigo;
	private int Qtd;
	private double Preco;
	public Carrinho(String C) {
		this.Codigo = C;
	}
	public void setCodigo(String NovoCodigo) {
		this.Codigo = NovoCodigo;
	}
	public String getCodigo () {
		return this.Codigo;
	}
	public void setQtd(int NovoQtd) {
		this.Qtd = NovoQtd;
	}
	public int getQtd () {
		return this.Qtd;
	}
	public void setPreco(double NovoPreco) {
		this.Preco = NovoPreco;
	}
	public double getPreco () {
		return this.Preco;
	}
	@Override
	public String toString() {
		return "C�digo do Produto: " + this.Codigo + " Quantidade: " + this.Qtd + " Pre�o: " +this.Preco;
	}

	public int compareTo(Carrinho C) {
		return this.Codigo.compareTo(C.getCodigo());
	}

}
