package br.unicap.p3.View;

import br.unicap.p3.Controle.FachadaControle;
import br.unicap.p3.Controle.Gerente;
import br.unicap.p3.Exceptions.ListaVaziaException;
import br.unicap.p3.Exceptions.ProdutosException;
import br.unicap.p3.Exceptions.QuantidadeIndisponivelException;
import br.unicap.p3.Exceptions.ValorRepetidoException;

public class FachadaView {
	private AreaCliente AC = new AreaCliente();
	private AreaVendedor AV = new AreaVendedor();
	private Gerente G = new Gerente();
	private static FachadaView FV = new FachadaView();
	
	public static FachadaView getObjeto () {
		return FV;
	}
	private FachadaView () {
		
	}
	//cliente
	public void LoginCliente () {
		AC.Login();
	}
	public void AreadoCliente () throws ProdutosException, QuantidadeIndisponivelException, ValorRepetidoException, ListaVaziaException {
		AC.AreadoCliente();
	}
	public void ControledoPedido () {
		AC.ControlePedido();
	}
	public void ControleCarrinho () throws ProdutosException, ListaVaziaException {
		AC.ControleCarrinho();
	}
	//vendedor
	public void LoginVendedor () throws ProdutosException {
		AV.Login();
	}
	public void AreadoVendedor () throws ProdutosException {
		AV.AreadoVendedor();
	}
	//gerente
	public void LoginGerente () throws ListaVaziaException, ValorRepetidoException {
		G.LoginGerente();
	}
 
}
