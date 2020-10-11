package br.unicap.p3.Exceptions;

public class ProdutosException extends Exception {
	public ProdutosException() {
		super("Produto não encontrado");
	}
}
