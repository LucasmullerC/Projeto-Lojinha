package br.unicap.p3.Controle;

import java.util.ArrayList;
import java.util.Iterator;

import br.unicap.p3.Exceptions.ValorRepetidoException;
import br.unicap.p3.Model.GerenciarLista;
import br.unicap.p3.Model.Produto;

public class ListaPedidos {

    private ArrayList<Produto> listapedidos;

    public ListaPedidos() {
    	GerenciarLista <Produto> GL = new GerenciarLista <Produto> ();
        listapedidos = GL.CriarLista();
    }

    public void AdicionarPedido(Produto p) {
        listapedidos.add(p);
    }

    public void HistoricoPedidos() {
    	Iterator iterator = listapedidos.iterator();
    	while (iterator.hasNext()) {
    		Produto obj = (Produto) iterator.next();
    		System.out.println(obj);
    	}
    }
}
