package br.unicap.p3.Vendedor;

import java.util.Scanner;

import br.unicap.p3.Aplicacao.AreaVendedor;
import br.unicap.p3.Dados.VerificarCPF;
import br.unicap.p3.Exceptions.CPFInvalidoCaracterException;
import br.unicap.p3.Exceptions.CPFInvalidoNumException;
import br.unicap.p3.Exceptions.ProdutosException;
import br.unicap.p3.Exceptions.SenhaCPFException;
import br.unicap.p3.Gerente.Gerente;

public class Funcionario {

    public void LoginFuncionario() throws ProdutosException, SenhaCPFException {
        Scanner input = new Scanner(System.in);
        AreaVendedor AV = new AreaVendedor();
        Gerente G = new Gerente();
        Vendedor Vef,v;
        String CPF;
        String Senha;
        boolean vefC = false;
        input.nextLine();
        do {
           System.out.print("Digite o seu CPF: ");
           CPF = input.nextLine();
           try {
				vefC = VerificarCPF.VerificarConta(CPF);
			} catch (CPFInvalidoCaracterException | CPFInvalidoNumException e) {
				e.printStackTrace();
			}
       } while (vefC == false);
       System.out.print("Digite a sua senha: ");
       Senha = input.nextLine();
        v = new Vendedor(CPF);
        v.setSenha(Senha);
        Vef = G.BuscaVendedor(v);
        System.out.println(Vef.getSenha());
        if (Vef.getSenha().compareTo(Senha) == 0 && Vef != null) {
           System.out.println("Login efetuado com sucesso");
            AV.AreadoVendedor();
        } else {
        	throw new SenhaCPFException();
        }
    }
}