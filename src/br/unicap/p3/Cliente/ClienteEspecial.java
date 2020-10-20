package br.unicap.p3.Cliente;
public class ClienteEspecial extends Cliente{
	public ClienteEspecial(String c) { // construtor
        super(c);
    }
	private int Pontos;
	
	public void setPontos (int P) {
		this.Pontos = P;
	}
	public int getPontos () {
		return this.Pontos;
	}
	 @Override
	    public String toString() {
	        return "O cliente especial tem CPF: " + this.getCpf() + " e Senha: " + this.getSenha()+ " e possui " +this.Pontos+ " pontos.";
	    }

}
