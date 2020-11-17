package br.unicap.p3.Model;

public class Cliente extends PessoaGeral{
    public Cliente(String c) { // construtor
        super(c);
    }
    
    @Override
    public String toString() {
        return "O cliente tem CPF: " + this.getCpf() + " e Senha: " + this.getSenha();
    }
}