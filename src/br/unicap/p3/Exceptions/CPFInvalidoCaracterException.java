package br.unicap.p3.Exceptions;

public class CPFInvalidoCaracterException extends Exception{
	public CPFInvalidoCaracterException() {
		super("CPF inv�lido. Informe exatamente 11 caracteres");
	}

}
