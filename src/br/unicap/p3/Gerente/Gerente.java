package br.unicap.p3.Gerente;
import java.util.Scanner;
import br.unicap.p3.Aplicacao.Menus;
import br.unicap.p3.Cliente.PessoaGeral;
import br.unicap.p3.Dados.*;
import br.unicap.p3.Exceptions.CPFInvalidoCaracterException;
import br.unicap.p3.Exceptions.CPFInvalidoNumException;
import br.unicap.p3.Exceptions.ListaVaziaException;
import br.unicap.p3.Exceptions.ValorNaoEncontradoException;
import br.unicap.p3.Exceptions.ValorRepetidoException;
import br.unicap.p3.Vendedor.Vendedor;
import br.unicap.p3.Dados.*;
public class Gerente extends SubGerente{
    public void LoginGerente() throws ListaVaziaException, ValorRepetidoException {
        Scanner input = new Scanner(System.in);
        int senha;
        Gerente G = new Gerente();

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
                    G.Demitir();
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
				VC = VerificarCPF.VerificarConta(cpf);
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