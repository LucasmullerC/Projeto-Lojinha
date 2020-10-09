package br.unicap.p3.Vendedor;
import java.util.Scanner;
import br.unicap.p3.Dados.LSESemRepetidos;
import br.unicap.p3.Dados.ListadoProduto;
import br.unicap.p3.Dados.VerificarCPF;
import br.unicap.p3.Produto.ProdutoP3;
public class Funcionario {
    private ListadoProduto<ProdutoP3> gerenciar;
	private LSESemRepetidos<Vendedor> verificar;

        public Funcionario(){
            gerenciar = new ListadoProduto<ProdutoP3>();
		verificar = new LSESemRepetidos<Vendedor>();
        }
        public double ObterPreço(String cod){
            double preço;
            ProdutoP3 p,aux;
            p = new ProdutoP3(cod);
            aux = gerenciar.AlterarValor(p);
//Expetion Aqui
            preço = aux.getPreco();
            return preço;
        }
        
        public void LoginFuncionario() {
		Scanner input = new Scanner(System.in);
		String cpf, senha;
		boolean VC;

		Vendedor v;
		Vendedor Vef;
		do {
			System.out.print("Digite o seu CPF: ");
			cpf = input.nextLine();
			VC = VerificarCPF.VerificarConta(cpf);
		}while (VC == false);
		v = new Vendedor(cpf);
		System.out.println("Digite a senha: ");
		senha = input.nextLine();

		Vef = verificar.BuscarObjeto(v);
		if (Vef.getSenha().equals(senha)) {
			System.out.print("Login efetuado com sucesso");
		} else {
			System.out.print("N�o encontrado");
		}
		int op;
		do {

			menuOpcoes();
			System.out.println("Informe a op��o: ");
			op = input.nextInt();
			input.nextLine();
			switch (op) {
			case 1:
                            
				System.out.println("Digite o nome do produto: ");
				
				//ListadoProduto.Cadastrar();
				break;
			case 2:
				//ListadoProduto.Remover();
				break;
			case 3:
				//ListadoProduto.AlterarValor();
				break;

			case 0:
				System.out.println(" ");
				break;
			default:
				System.out.println("Op��o inv�lida!");
			}
		} while (op != 0);
	}

	public void menuOpcoes() {
		System.out.println("1 - Cadastrar Produtos  ");
		System.out.println("2 - Excluir Produtos");
		System.out.println("3 - Alterar Produtos ");
		System.out.println("0 - Voltar ao Menu Principal");

	}
}


