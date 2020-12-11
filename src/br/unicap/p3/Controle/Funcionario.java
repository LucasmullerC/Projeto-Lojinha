package br.unicap.p3.Controle;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import br.unicap.p3.Controle.SaveLogin.Memento;
import br.unicap.p3.Exceptions.CPFInvalidoCaracterException;
import br.unicap.p3.Exceptions.CPFInvalidoNumException;
import br.unicap.p3.Exceptions.ProdutosException;
import br.unicap.p3.Exceptions.SenhaCPFException;
import br.unicap.p3.Model.GerenciarLista;
import br.unicap.p3.Model.PessoaGeral;
import br.unicap.p3.Model.Vendedor;
import br.unicap.p3.View.AreaVendedor;
import br.unicap.p3.View.FachadaView;

public class Funcionario {
	ArrayList<Memento> savedStates = new ArrayList<SaveLogin.Memento>();
	private static ArrayList<PessoaGeral> gerenciar = getList() ;
	private FachadaControle FC = FachadaControle.getObjeto();;
	private FachadaView FV = FachadaView.getObjeto();
	SaveLogin originator = new SaveLogin();
    private String estado;

    public void LoginFuncionario() throws ProdutosException, SenhaCPFException {
        Scanner input = new Scanner(System.in);
        Vendedor Vef,v;
        String CPF;
        String Senha;
        int codigo;
        boolean vefC = false;
        input.nextLine();
        do {
            System.out.print("Digite o seu CPF: ");
            CPF = input.nextLine();
            try {
				vefC = VerificarCPF.VerificarConta(CPF);
			} catch (CPFInvalidoCaracterException | CPFInvalidoNumException e) {
				e.printStackTrace();
			}
        } while (vefC == false);
        System.out.print("Digite a sua senha: ");
        Senha = input.nextLine();
        v = new Vendedor(CPF);
        v.setSenha(Senha);
        System.out.print("Digite o código: ");
        codigo = input.nextInt();
        Vef = (Vendedor) gerenciar.get(codigo);
        if (Vef.getSenha().compareTo(Senha) == 0 && Vef != null) {
            System.out.println("Login efetuado com sucesso");
            originator.set(CPF);
            savedStates.add(originator.saveToMemento());
        }
    }
    public static void setList (ArrayList<PessoaGeral> arrayList) {
    	gerenciar = arrayList;
    }
    public static ArrayList<PessoaGeral> getList() {
        return gerenciar;
    }
    public void UltimosAcessos () {
    	Iterator Acessos = savedStates.iterator();
    	while (Acessos.hasNext()) {
    		Memento obj = (Memento) Acessos.next();
    		System.out.println(obj);
    	}
    }
    
}