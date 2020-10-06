package br.unicap.p3.Cliente;

public class Cliente implements Comparable<Cliente> {

	private String cpf;
	private String senha;

	public Cliente(String c) { // construtor
		this.cpf = c;

	}

	public void setCpf(String c) {
		this.cpf = c;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setSenha(String s) {
		this.senha = s;
	}

	public String getSenha() {
		return this.senha;
	}

	@Override
	public String toString() {
		return ">CPF: " + this.cpf + "/Senha: " + this.senha;
	}

	public int compareTo(Cliente a) {
		return this.cpf.compareTo(a.getCpf());
	}

}