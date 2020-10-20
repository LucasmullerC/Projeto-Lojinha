package br.unicap.p3.Produto;

public class ProdutoPerecivel extends Produto {
	public ProdutoPerecivel(String C) {
		super(C);
	}

	private String data;

	public void setData(String D) {
		this.data = D;
	}

	public String getData() {
		return this.data;
	}
	@Override
    public String toString () {
        return "O produto " + this.getNome() + " de código " + this.getCodigo() + " tem pre�o de R$ " + this.getPreco() + " e tem " + this.getEstoque() + " unidades no estoque e sua data de val�dade � " +this.data;
    }

}
