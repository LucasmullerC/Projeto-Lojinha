package br.unicap.p3.Dados;
public class VerificarCPF {
	public static boolean VerificarConta(String C) {
		if (C.length() != 11) {
			System.out.println("N�mero da conta inv�lido. Informe exatamente 11 caracteres");
			return false;
		} else if (VerificarContaNum(C) == false) {
			System.out.println("N�mero de conta inv�lido. Informe apenas d�gitos num�ricos.");
			return false;
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
