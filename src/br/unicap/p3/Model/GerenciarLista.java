package br.unicap.p3.Model;

public class GerenciarLista <T extends Comparable <T>> {
	public LSESemRepetidos <T> CriarLista () {
		return new LSESemRepetidos<T>();	
	}
	

}
