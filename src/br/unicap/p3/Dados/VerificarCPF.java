package br.unicap.p3.Dados;

import br.unicap.p3.Exceptions.*;


public class VerificarCPF {
	public static boolean VerificarConta(String C) throws CPFInvalidoCaracterException, CPFInvalidoNumException {
		if (C.length() != 11) {
			throw new CPFInvalidoCaracterException();
		} else if (VerificarContaNum(C) == false) {
			throw new CPFInvalidoNumException();
		}
		return true;
	}
	public static boolean VerificarContaNum(String C) {
		int tam = C.length(), i;
		char num;
		boolean Resultado = true;

		for (i = 0; i < tam; i++) {
			num = C.charAt(i);
			if (Character.isDigit(num) == false) {
				Resultado = false;
				break;
			}
		}
		return Resultado;
	}
}
