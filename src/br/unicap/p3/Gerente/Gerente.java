package br.unicap.p3.Gerente;
import java.util.Scanner;

import br.unicap.p3.Aplicacao.Menus;
import br.unicap.p3.Cliente.PessoaGeral;
import br.unicap.p3.Dados.*;
import br.unicap.p3.Vendedor.Vendedor;

public class Gerente {
    private LSESemRepetidos<PessoaGeral> gerenciar;

    public Gerente() {
        gerenciar = new LSESemRepetidos<PessoaGeral>();
    }

    public void LoginGerente() {
        Scanner input = new Scanner(System.in);
        int senha;

        System.out.println("Digite a sua senha: ");
        senha = input.nextInt();
        while (senha != 123) {
            System.out.println("Senha incorreta,digite novamente: ");
            senha = input.nextInt();
        }
        int op;
        do {
            Menus.MenuGerente();
            System.out.println("Informe a op��oo: ");
            op = input.nextInt(); input.nextLine();
            switch (op) {
                case 1:
                    Contratar();
                    break;
                case 2:
                    Demitir();
                    break;
                case 3:exibirVendedores();

                    break;

                case 0:
                    System.out.println(" ");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    public void Contratar() {
        Scanner input = new Scanner(System.in);
        Vendedor v;
        String cpf, senha;
        System.out.println("Digite o cpf do novo funcionário: ");
        cpf = input.nextLine();
        System.out.println("Informe A senha: ");
        senha = input.nextLine();
        v = new Vendedor(cpf);
        v.setSenha(senha);
        gerenciar.inserirNoFinal(v);
        System.out.println("Vendedor contratado!");
    }

    public Vendedor BuscaVendedor(Vendedor v) {
        Vendedor Vef;
        
        Vef = (Vendedor) gerenciar.BuscarObjeto(v);
        return Vef;
    }

    public void exibirVendedores() {
        gerenciar.exibirTodos();
    }

    public void Demitir() {
        Scanner input = new Scanner(System.in);
        String cpf, senha;
        boolean VC;

        Vendedor v;
        Vendedor Vef;
        do {
            System.out.println("Digite o CPF do funcion�rio a ser demitido: ");
            cpf = input.nextLine();
            VC = VerificarCPF.VerificarConta(cpf);
        } while (VC == false);
        v = new Vendedor(cpf);
        System.out.println("Digite a senha: ");
        senha = input.nextLine();

        Vef = (Vendedor) gerenciar.BuscarObjeto(v);
        if (Vef.getSenha().equals(senha)) {
            gerenciar.Remover(v);
            System.out.print("Funcionário Demitido");

        } else {
            System.out.print("Não encontrado");
        }
    }
}