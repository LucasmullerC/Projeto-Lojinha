package br.unicap.p3.Pedidos;

import br.unicap.p3.Carrinho.*;

public class RegistrarPedido {

    public void RegistrarPedido(Carrinho c) {
        Pedidos p;
        ListaPedidos lista = new ListaPedidos();
        String cod = c.getCodigo();;
        double preco = c.getPreco();
        int qtd = c.getQtd();
        p = new Pedidos(cod);
        p.setPreco(preco);
        p.setQtd(qtd);
        lista.AdicionarPedido(p);

    }

}
