package br.unicap.p3.Exceptions;

public class QuantidadeIndisponivelException extends Exception{
	public QuantidadeIndisponivelException() {
		super("Quantidade indisponível no estoque!");
	}

}
