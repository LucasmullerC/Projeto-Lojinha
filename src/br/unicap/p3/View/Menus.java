package br.unicap.p3.View;
public class Menus {
	public static void MenuInicio () {
		System.out.println("Bem-Vindo a Lojinha!");
		System.out.println("1 - Cliente");
		System.out.println("2 - Vendedor");
		System.out.println("3 - Gerente");
		System.out.println("0 - Sair");
		System.out.println("Informe a op��o: ");
	}
	public static void MenuLogin () {
		System.out.println("1 - Login");
		System.out.println("2 - Registro");
		System.out.println("0 - Voltar");
		 System.out.println("Op��o:");
	}
	public static void MenuLoginVendedor () {
		System.out.println("1 - Login");
		System.out.println("0 - Voltar");
		 System.out.println("Op��o:");
	}
	public static void MenuCliente () {
		System.out.println("�rea do Cliente");
		System.out.println("1 - Cat�logo");
		System.out.println("2 - Carrinho");
		System.out.println("3 - Pedidos");
		System.out.println("0 - Sair");
		 System.out.println("Op��o:");
	}
	public static void MenuCarrinho() {
        System.out.println("1-Exibir produtos no Carrinho");
        System.out.println("2-Exibir a soma total dos produtos no Carrinho");
        System.out.println("3-Excluir produto do Carrinho");
        System.out.println("4-Corfimar compra dos produtos no Carrinho");
        System.out.println("0-Sair do Menu de Carrinho");
        System.out.println("Op��o:");
    }
	public static void MenuPedidos() {
        System.out.println("1-Exibir Historico de Pedidos");
        System.out.println("0-Sair do Menu de Pedidos:");
        System.out.println("Op��o:");
    }
	public static void MenuAlterarProduto () {
		System.out.println("Selecione o que deseja alterar: ");
		System.out.println("1-Alterar pre�o");
        System.out.println("2-Alterar estoque ");
        System.out.println("3-Alterar pre�o e estoque");
        System.out.println("Op��o:");
	}
	public static void MenuVendedor () {
		System.out.println("�rea do vendedor:");
		System.out.println("1-Cadastrar Produto");
        System.out.println("2-Excluir Produto");
        System.out.println("3-Alterar Produto");
        System.out.println("0-Sair");
        System.out.println("Op��o:");
	}
	public static void MenuGerente() {
		System.out.println("1 - Contratar funcionário  ");
		System.out.println("2 - Demitir Funcionário");
		System.out.println("3 - Exibir Ganhos");
		System.out.println("0 - Voltar ao Menu Principal");

	}
	

}
