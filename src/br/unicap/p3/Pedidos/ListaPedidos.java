package br.unicap.p3.Pedidos;

import br.unicap.p3.Dados.LSESemRepetidos;

public class ListaPedidos {

    private final LSESemRepetidos<Pedidos> listapedidos;

    public ListaPedidos() {
        listapedidos = new LSESemRepetidos();
    }

    public void AdicionarPedido(Pedidos p) {
        listapedidos.inserirNoFinal(p);
    }

    public void HistoricoPedidos() {
        listapedidos.exibirTodos();
    }
}
