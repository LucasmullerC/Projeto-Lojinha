package br.unicap.p3.Exceptions;

public class CPFInvalidoNumException extends Exception {
	public CPFInvalidoNumException() {
		super("Número de conta inválido. Informe apenas dígitos numéricos.");
	}
		
	}
