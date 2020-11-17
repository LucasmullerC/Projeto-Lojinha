package br.unicap.p3.Model;

public class Vendedor extends PessoaGeral {
    public Vendedor (String C) { // construtor
        super(C);
    }
    
    @Override
    public String toString () {
        return "O vendedor tem o CPF igual a " + this.getCpf() + " e sua senha é " + this.getSenha();
    }
}