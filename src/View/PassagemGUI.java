package View;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Passagem;

public class PassagemGUI {

	
	public PassagemGUI(){
		
	}
	
	public int mostraTelaPassagem(){
		Scanner sc = new Scanner (System.in);
		System.out.println("1 - Cadastrar uma passagem \n"
						+ " 2 - Cancelar uma passagem\n"
						+ " 3 - Atualizar uma passagem\n"
						+ " 4 - Buscar uma passagem\n"
						+ " 5 - Listar uma passagem \n"
						+ " 6 - Retornar ao menu principal \n");
		int opcao = sc.nextInt();
		return opcao;
	}
	public static void resultadoBusca(Passagem passagem) {
		System.out.println("Passagem encontrado:\nCodigo: "+ passagem.getCod_passagem() +"\n"+"Data: "+ passagem.getData()+"\n"+"Destino: "+ passagem.getDestino()+"\n"+"Hora: "+ passagem.getHora()+"\n"
				+"Cod Onibus: "+ passagem.getId_onibus()+"\n"+"Origem: "+passagem.getOrigem()+"\n"+"Preço: "+passagem.getPreco()+"Tipo: "+passagem.getTipo()+"\n");
	}
	public static void resultadoLista(ArrayList<Passagem>passagem){		
		for(Passagem cursor : passagem) {
			System.out.println("|código passagem|  |   data   |  |   origem  |  |  destino  |  |  horas  |    |id do ônibus|    |preço|  |  tipo    | \n|"+cursor.getCod_passagem()+"|          |"+ cursor.getData() +"|     |"+ cursor.getOrigem() +"|      |"+ cursor.getDestino() +"|      |"+ cursor.getHora() +"|      |"+ cursor.getId_onibus() +"|        |"+ cursor.getPreco() +"|     |"+ cursor.getTipo()+"| \n");
		}
	}
}