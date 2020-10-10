package br.unicap.p3.Carrinho;

import java.util.Scanner;

public class ControleCarrinho {

    public static void Escolha() {
        System.out.println("1-Exibir produtos no Carrinho");
        System.out.println("2-Exibir a soma total dos produtos no Carrinho");
        System.out.println("3-Excluir produto do Carrinho");
        System.out.println("4-Corfimar compra dos produtos no Carrinho");
        System.out.println("0-Sair do Menu de Carrinho");
        System.out.println("Opção:");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListaCarrinho lista = new ListaCarrinho();
        int op;
        double total;
        do {
            Escolha();
            op = in.nextInt();
            in.nextLine();
            switch (op) {
                case 1:
                    lista.ExibirCarrinho();
                    break;
                case 2:
                    total = lista.ExibirTotalPreco();
                    System.out.println("R$: " + total);
                    break;
                case 3:
                    System.out.println("Insira o codigo do produto que deseja retirar do Carrinho:");
                    String cod = in.nextLine();
                    lista.ExcluirCompra(cod);
                    break;
                case 4:
                    lista.CofirmarCompra();
                    break;
                case 0:
                    System.out.println("Voltar");
                    break;
                default:
                    System.out.println("opção incorreta");
                    break;
            }
        } while (op != 0);
    }
}
