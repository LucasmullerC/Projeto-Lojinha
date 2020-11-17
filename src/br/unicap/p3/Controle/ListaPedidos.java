package br.unicap.p3.Controle;

import br.unicap.p3.Exceptions.ValorRepetidoException;
import br.unicap.p3.Model.LSESemRepetidos;
import br.unicap.p3.Model.Produto;

public class ListaPedidos {

    private LSESemRepetidos<Produto> listapedidos;

    public ListaPedidos() {
        listapedidos = new LSESemRepetidos<Produto>();
    }

    public void AdicionarPedido(Produto p) {
        try {
			listapedidos.inserirOrdenado(p);
		} catch (ValorRepetidoException e) {
			e.printStackTrace();
		}
    }

    public void HistoricoPedidos() {
        listapedidos.exibirTodos();
    }
}
