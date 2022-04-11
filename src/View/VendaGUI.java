package View;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Venda;

public class VendaGUI {

	
	public VendaGUI(){
		
	}
	
	public int mostraTelaVenda(){
		Scanner sc = new Scanner (System.in);
		System.out.println(" 1 - Efetuar uma venda \n"
						+ " 2 - Cancelar uma venda\n"
						+ " 3 - Atualizar uma venda\n"
						+ " 4 - Buscar uma venda\n"
						+ " 5 - Listar uma venda\n"
						+ " 6 - Retornar ao menu principal \n");
		int opcao = sc.nextInt();
		return opcao;
	}
	
	public static void resultadoBusca(Venda venda) {
		System.out.println("Codigo Do atendente: "+ venda.getCod_atendente()+"\n Codigo da passagem: "+venda.getCod_passagem()+"\n Cpf do cliente: "+venda.getCpf_comprador()+"\n Data de nascimeto do cliente: "+venda.getDatanasc()
		  +"\n Hora da viagem: "+venda.getHora()+"\n Id da venda: "+venda.getId()+"\n Nome do Cliente: "+venda.getNome_cliente()+"\n Id do onibus: "+venda.getOnibus_id()+"\n Passagem preferencial ? "+venda.getPreferencial()+"\n Rg do Cliente: "+venda.getRg());
	}
	public static void resultadoLista(ArrayList<Venda>venda){		
		for(Venda cursor : venda) {
			System.out.println("|código do atendente|  |código da passagem|  |cpf do cliente|  |data de nascimento|  |hora da venda|  |id|  |nome do cliente|  |id do ônibus|  |preferências|  |rg do cliente|\n "+cursor.getCod_atendente()+"                       "+cursor.getCod_passagem()+"                 "+cursor.getCpf_comprador()+"            "+cursor.getDatanasc()+"           "+cursor.getHora()+"       "+cursor.getId()+"       "+cursor.getNome_cliente()+"         "+cursor.getOnibus_id()
			+"            "+cursor.getPreferencial()+"           "+cursor.getRg()+"\n");
		}
	}
}