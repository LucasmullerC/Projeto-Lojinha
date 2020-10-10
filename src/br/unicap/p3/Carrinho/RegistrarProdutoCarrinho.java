package br.unicap.p3.Carrinho;

import java.util.Scanner;

public class RegistrarProdutoCarrinho {
    
    public void RegistrarProduto() {
        ListaCarrinho lista = new ListaCarrinho();
        Scanner in = new Scanner(System.in);
        String cod;
        int qtd;
        System.out.println("Insira o codigo do produto deejado: ");
        cod = in.nextLine();
        System.out.println("insira a quantidade do produto desejado: ");
        qtd = in.nextInt();
        in.nextLine();
        while (qtd <= 0) {
            System.out.println("Insira um vaor maior que zero ");
            qtd = in.nextInt();
            in.nextLine();
        }
        lista.AdicionarNoCarrinho(cod, qtd);
    }
}
