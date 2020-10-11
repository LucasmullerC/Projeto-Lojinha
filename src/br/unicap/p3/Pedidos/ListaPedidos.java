package br.unicap.p3.Pedidos;

import br.unicap.p3.Dados.LSESemRepetidos;
import br.unicap.p3.Produto.Produto;

public class ListaPedidos {

    private LSESemRepetidos<Produto> listapedidos;

    public ListaPedidos() {
        listapedidos = new LSESemRepetidos<Produto>();
    }

    public void AdicionarPedido(Produto p) {
        listapedidos.inserirOrdenado(p);
    }

    public void HistoricoPedidos() {
        listapedidos.exibirTodos();
    }
}
