package br.unicap.p3.Vendedor;

public class Vendedor implements Comparable <Vendedor> {
    private final String CPF;
    private String nome;
    private String senha;
    
    public Vendedor (String C) { // construtor
        this.CPF = C;
    }
    
    public String getCPF () {
        return this.CPF;
    }  
    public void setNome (String n){
        this.nome = n;
    }   
    public String getNome () {
        return this.nome;
    }
    public void setSenha (String s){
        this.senha = s;
    }   
    public String getSenha () {
        return this.senha;
    }
    @Override
    public String toString () {
        return "O vendedor " + this.nome + " tem o CPF igual a " + this.CPF + " e sua senha é " + this.senha;
    }
    @Override
    public int compareTo(Vendedor v) {
        return this.CPF.compareTo(v.getCPF());
    }
}