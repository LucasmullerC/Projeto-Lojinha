package br.unicap.p3.Produto;

public class ProdutoP3 implements Comparable <ProdutoP3> {
    private final String codigo;
    private String nome;
    private double preco;
    private int estoque;
    
    public ProdutoP3 (String C) { // construtor
        this.codigo = C;
    }
    
    public String getCodigo () {
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
    public void setEstoque (int e) {
        this.estoque = e;
    }   
    public int getEstoque () {
        return this.estoque;
    }
    @Override
    public String toString () {
        return "O produto " + this.nome + " de código " + this.codigo + " tem preço de R$ " + this.preco + " e tem " + this.estoque + " unidades no estoque";
    }
    @Override
    public int compareTo(ProdutoP3 p) {
        return this.codigo.compareTo(p.getCodigo());
    }
}