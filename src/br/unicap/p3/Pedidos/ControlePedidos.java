package br.unicap.p3.Pedidos;

import br.unicap.p3.Carrinho.*;
import java.util.Scanner;

public class ControlePedidos {

    public static void Escolha() {
        System.out.println("1-Exibir Historico de Pedidos");
        System.out.println("0-Sair do Menu de Pedidos:");
        System.out.println("Opção:");
    }

    public static void main(String[] args) {
        ListaPedidos lista = new ListaPedidos();
        Scanner in = new Scanner(System.in);
        int op;
        do {
            Escolha();
            op = in.nextInt();
            in.nextLine();
            switch (op) {
                case 1:
                    lista.HistoricoPedidos();
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
