package View;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Onibus;


public class OnibusGUI {

	
	public OnibusGUI(){
		
	}
	
	public int mostraTelaOnibus(){
		Scanner sc = new Scanner (System.in);
		System.out.println(" 1 - Cadastrar um ônibus \n"
						+ " 2 - Remover um ônibus\n"
						+ " 3 - alterar um ônibus\n"
						+ " 4 - buscar um ônibus\n"
						+ " 5 - Listar os ônibus \n"
						+ " 6 - Retornar ao menu principal \n");
		int opcao = sc.nextInt();
		return opcao;
	}
	
	public static void resultadoBusca(Onibus onibus) {
		System.out.println("Ônibus encontrado:\nID: "+ onibus.getId() +"\n"+"Numeros poltronas: "+ onibus.getNumPoltrona()+"\n"+"Tipo: "+ onibus.getTipo()+"\n"+"Status: "+ onibus.getStatus()+"\n");
	}
	public static void resultadoLista(ArrayList<Onibus>onibus){		 
		for(Onibus cursor : onibus) {
			System.out.println("|  ID  ||números de poltronas||  tipo  ||  status  | \n|"+cursor.getId() +"  ||           "+ cursor.getNumPoltrona() +"       ||"+ cursor.getTipo() +"||   "+ cursor.getStatus() +"| \n");
		} 
	}
}