package br.unicap.p3.Model;

public class Produto implements Comparable <Produto> {
    private int estoque;
    private final int codigo;
    private String nome;
    private double preco;
    
    public Produto (int C) { // construtor
        this.codigo = C;
    }
    
    public int getCodigo () {
        return this.codigo;
    }  
    public void setNome (String n){
        this.nome = n;
    }   
    public String getNome () {
        return this.nome;
    }
    public void setPreco (double p) {
        this.preco = p;
    }   
    public double getPreco () {
        return this.preco;
    }
    public void setEstoque(int e) {
        this.estoque = e;
    }
    public int getEstoque() {
        return this.estoque;
    }
    @Override
    public String toString () {
        return "O produto " + this.nome + " de código " + this.codigo + " tem preço de R$ " + this.preco + " e tem " + this.estoque + " unidades no estoque";
    }
    @Override
    public int compareTo(Produto p) {
        return this.nome.compareTo(p.getNome());
    }
}