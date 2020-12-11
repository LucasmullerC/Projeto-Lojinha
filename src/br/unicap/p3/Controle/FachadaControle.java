package br.unicap.p3.Controle;

import br.unicap.p3.Exceptions.CPFInvalidoCaracterException;
import br.unicap.p3.Exceptions.CPFInvalidoNumException;
import br.unicap.p3.Exceptions.ListaVaziaException;
import br.unicap.p3.Exceptions.ProdutosException;
import br.unicap.p3.Exceptions.QuantidadeIndisponivelException;
import br.unicap.p3.Exceptions.SenhaCPFException;
import br.unicap.p3.Exceptions.ValorRepetidoException;
import br.unicap.p3.Model.Produto;
import br.unicap.p3.Model.Vendedor;

public class FachadaControle {
	private AcessoCliente AC = new AcessoCliente ();
	private Carrinho C = new Carrinho ();
	private Funcionario F = new Funcionario ();
	private GerenciarProdutos GP = new GerenciarProdutos ();
	private Gerente G = new Gerente ();
	private ListaPedidos LP = new ListaPedidos ();
	private VerificarCPF CPF = new VerificarCPF ();
	private static FachadaControle FC = new FachadaControle ();
	
	public static FachadaControle getObjeto () {
		return FC;
	}
	private FachadaControle () {
		
	}
	
	//AcessoCliente
	public void CadastroCliente() throws ValorRepetidoException {
		AC.Cadastro();
	}
	public void LoginCliente () throws ProdutosException, QuantidadeIndisponivelException, SenhaCPFException, ValorRepetidoException, ListaVaziaException {
		AC.Login();
	}
	//carrinho
	public void AdicionarnoCarrinho (int codigo, int qtd) throws ProdutosException, QuantidadeIndisponivelException, ValorRepetidoException {
		C.AdicionarNoCarrinho(codigo, qtd);
	}
	public void ExibirCarrinho () {
		C.ExibirCarrinho();
	}
	public double ExibirPrecoTotal () {
		return C.ExibirTotalPreco();
	}
	public void ConfirmarCompra () throws ProdutosException {
		C.CofirmarCompra();
	}
	public void ExcluirCompra (int cod) throws ProdutosException, ListaVaziaException {
		C.ExcluirCompra(cod);
	}
	//funcionario
	public void LoginFuncionario () throws ProdutosException, SenhaCPFException {
		F.LoginFuncionario();
	}
	public void UltimosAcessos() {
		F.UltimosAcessos();
	}
	//GerenciarProdutos
	public Produto ObterProduto (int cod) {
		return GP.ObterProduto(cod);
	}
	public void Catalogo () {
		GP.Catalogo();
	}
	public void RemoverProduto () {
		GP.RemoverProduto();
	}
	public void AlterarProduto () throws ProdutosException {
		GP.AlterarProduto();
	}
	public void CadastrarProduto () {
		GP.CadastrarProduto();
	}
	//Gerente
	public void LoginGerente () throws ListaVaziaException, ValorRepetidoException {
		G.LoginGerente();
	}
	public void Contratar () throws ValorRepetidoException {
		G.Contratar();
	}
	public void ExibirVendedor () {
		G.exibirVendedores();
	}
	public void Demitir () throws ListaVaziaException {
		G.Demitir();
	}
	//ListaPedidos
	public void AdicionarPedido (Produto p) {
		LP.AdicionarPedido(p);
	}
	public void HistoricoPedidos () {
		LP.HistoricoPedidos();
	}
	//VerificarCPF
	public boolean VerificarConta (String C) throws CPFInvalidoCaracterException, CPFInvalidoNumException {
		return CPF.VerificarConta(C);
	}
	
	
	
}