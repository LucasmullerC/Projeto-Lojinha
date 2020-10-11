package br.unicap.p3.Vendedor;

import java.util.Scanner;

import br.unicap.p3.Aplicacao.AreaVendedor;
import br.unicap.p3.Dados.VerificarCPF;
import br.unicap.p3.Gerente.Gerente;

public class Funcionario {

    public void LoginFuncionario() {
        Scanner input = new Scanner(System.in);
        AreaVendedor AV = new AreaVendedor();
        Gerente G = new Gerente();
        Vendedor Vef,v;
        String CPF;
        String Senha;
        boolean vefC;
        input.nextLine();
        do {
            System.out.print("Digite o seu CPF: ");
            CPF = input.nextLine();
            vefC = VerificarCPF.VerificarConta(CPF);
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
            System.out.println("Senha ou CPF inv�lido");
        }
    }
}