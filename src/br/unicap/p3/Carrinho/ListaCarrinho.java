package br.unicap.p3.Carrinho;
import br.unicap.p3.Dados.*;
import br.unicap.p3.Vendedor.*;
import br.unicap.p3.Produto.ProdutoP3;
public class ListaCarrinho {
    private LSESemRepetidos<Carrinho> listacarrinho;
    
    public ListaCarrinho(){
        listacarrinho = new LSESemRepetidos<Carrinho>();
        
    }
    
    
    public void AdicionarNoCarrinho(String cod,int qtd){
         Funcionario f = new Funcionario();
        double preco;
        Carrinho c;
        c = new Carrinho(cod);
        preco = f.ObterPreço(cod);
        c.setPreco(preco);
        c.setQtd(qtd);
        listacarrinho.inserirNoFinal(c);
    }
    public void ExibirCarrinho(){
        listacarrinho.exibirTodos();
    }
    public void CofirmarCompra(String cod){
        
    }
   
    
}
