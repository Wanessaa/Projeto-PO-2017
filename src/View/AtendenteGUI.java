package View;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Atendente;

public class AtendenteGUI {

	
	public AtendenteGUI(){
		
	}
	
	public int mostraTelaAtendente(){
		Scanner sc = new Scanner (System.in);
		System.out.println(" 1 - Cadastrar um atendente \n"
						+ " 2 - Remover um atendente\n"
						+ " 3 - Atualizar um atendente\n"
						+ " 4 - Buscar um atendente\n"
						+ " 5 - Listar os atendente \n"
						+ " 6 - Retornar ao menu principal \n");
		int opcao = sc.nextInt();
		return opcao;
	}
	
	public static void resultadoBusca(Atendente atendente) {
		System.out.println("Atendente encontrado:\nCod: "+ atendente.getCod() +"\n"+"Cpf: "+ atendente.getCpf()+"\n"+"Nome: "+ atendente.getNome()+"\n");
	}
	public static void resultadoLista(ArrayList<Atendente>atendentes){		
		for(Atendente cursor : atendentes) {
			System.out.println("|código|     |CPF|     |nome|\n "+cursor.getCod() +"          "+ cursor.getCpf() +"       "+ cursor.getNome()+"\n ");
		}
	}

	
	
}