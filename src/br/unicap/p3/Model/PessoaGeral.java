package br.unicap.p3.Model;

public abstract class PessoaGeral implements Comparable<PessoaGeral> {
    private String cpf;
    private String senha;
    private int codigo;

    public PessoaGeral(String c) { // construtor
        this.cpf = c;

    }
    public void setCodigo(int Nc) {
        this.codigo = Nc;
    }
    public int getCodigo() {
        return this.codigo;
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
    public int compareTo(PessoaGeral a) {
        return this.cpf.compareTo(a.getCpf());
    }
}
