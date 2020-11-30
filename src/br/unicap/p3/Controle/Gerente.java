package br.unicap.p3.Controle;
import java.util.Scanner;


import br.unicap.p3.Exceptions.CPFInvalidoCaracterException;
import br.unicap.p3.Exceptions.CPFInvalidoNumException;
import br.unicap.p3.Exceptions.ListaVaziaException;
import br.unicap.p3.Exceptions.ValorNaoEncontradoException;
import br.unicap.p3.Exceptions.ValorRepetidoException;
import br.unicap.p3.Model.GerenciarLista;
import br.unicap.p3.Model.LSESemRepetidos;
import br.unicap.p3.Model.PessoaGeral;
import br.unicap.p3.Model.Produto;
import br.unicap.p3.Model.Vendedor;
import br.unicap.p3.View.Menus;

public class Gerente {
    private LSESemRepetidos<PessoaGeral> gerenciar;
    private FachadaControle FC = FachadaControle.getObjeto();;

    public Gerente() {
    	GerenciarLista <PessoaGeral> GL = new GerenciarLista <PessoaGeral> ();
        gerenciar = GL.CriarLista();
    }

    public void LoginGerente() throws ListaVaziaException, ValorRepetidoException {
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

    public void Contratar() throws ValorRepetidoException {
        Scanner input = new Scanner(System.in);
        Vendedor v;
        String cpf, senha;
        System.out.println("Digite o CPF do novo funcionário: ");
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

    public void Demitir() throws ListaVaziaException {
        Scanner input = new Scanner(System.in);
        String cpf, senha;
        boolean VC = false;

        Vendedor v;
        Vendedor Vef;
        do {
            System.out.println("Digite o CPF do funcion�rio a ser demitido: ");
            cpf = input.nextLine();
            try {
				VC = FC.VerificarConta(cpf);
			} catch (CPFInvalidoCaracterException | CPFInvalidoNumException e) {
				e.printStackTrace();
			}
        } while (VC == false);
        v = new Vendedor(cpf);
        System.out.println("Digite a senha: ");
        senha = input.nextLine();

        Vef = (Vendedor) gerenciar.BuscarObjeto(v);
        if (Vef.getSenha().equals(senha)) {
            try {
				gerenciar.Remover(v);
			} catch (ValorNaoEncontradoException e) {
				e.printStackTrace();
			}
            System.out.print("Funcionário Demitido");

        } else {
            System.out.print("Não encontrado");
        }
    }
}