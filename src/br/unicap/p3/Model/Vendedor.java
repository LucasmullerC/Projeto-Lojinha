package br.unicap.p3.Model;

import java.util.ArrayList;

public class Vendedor extends PessoaGeral {

	public Vendedor (String C) { // construtor
        super(C);
    }
    
    @Override
    public String toString () {
        return "O vendedor de C�digo: " +this.getCodigo()+ " |CPF igual a " + this.getCpf() + " |e sua senha � " + this.getSenha();
    }
}