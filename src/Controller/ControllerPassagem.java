package Controller;

import java.util.Scanner;

import Model.Passagem;
import ModeloDAO.PassagemDAOImp;
import View.PassagemGUI;
import View.TelaPrincipal;

public class ControllerPassagem {
	private PassagemGUI telaPassagem;
	
	ControllerPassagem(){
		telaPassagem = new PassagemGUI();
		acoes();
	}
	
	public void acoes (){
		int opcao = telaPassagem.mostraTelaPassagem();
		do{
			switch(opcao){
			case 1:
				PassagemDAOImp passagemBD = new PassagemDAOImp();
				passagemBD.inserirPassagem(obtemPassagem());
				
				opcao = telaPassagem.mostraTelaPassagem();
				break;
			case 2:
				PassagemDAOImp passagemBD1 = new PassagemDAOImp();
				Scanner delete = new Scanner(System.in);
				System.out.println("Codigo da passagem :");
				String delet = delete.next();
				
				Passagem pas1 = passagemBD1.buscarPassagem(delet);
				if(pas1 != null) {
					passagemBD1.deletarPassagem(delet);
				}else{
					System.out.println("Não existe essa passagem");
				}
				
				opcao = telaPassagem.mostraTelaPassagem();
				break;
            case 3:
            	PassagemDAOImp passagemBD2 = new PassagemDAOImp();
            	Scanner alterar = new Scanner(System.in);
            	System.out.println("Codigo da passagem");
            	String codAltera = alterar.next();
            	
            	Passagem past2 = passagemBD2.buscarPassagem(codAltera);
            	if(past2 != null) {
            		System.out.println("Digite a nova origem");
            		String origem = alterar.next();
            		System.out.println("Digite o novo destino");
            		String destino = alterar.next();
            		System.out.println("Digite a data");
            		String data = alterar.next();
            		System.out.println("Digite a hora");
            		String hora = alterar.next();
            		System.out.println("Digite o preço");
            		double preco = alterar.nextDouble();
            		System.out.println("Passagem :     [1]Preferencial    [2]Normal");
					int res = alterar.nextInt();
					String tipo;
					if(res == 1) {
						tipo = "Preferencial";
					}else {
						tipo = "Normal";
					}
            		System.out.println("Digite o novo codigo da passagem");
            		String cod = alterar.next();
            		System.out.println("Digite o novo id do ônibus");
            		String id = alterar.next();
            		
            		passagemBD2.atualizarPassagem(origem, destino, data, hora, preco, tipo, cod, id,codAltera);
            	}else {
            		System.out.println("Não existe essa passagem no banco");
            	}
				
            	opcao = telaPassagem.mostraTelaPassagem();
				break;
				
            case 4:
            	PassagemDAOImp passagemBD3 = new PassagemDAOImp();
				Scanner buscar = new Scanner(System.in);
				System.out.println("Digite codigo da passagem");
				String codBusca = buscar.next();
				
				Passagem passagem = passagemBD3.buscarPassagem(codBusca);
				if(passagem != null) {
					telaPassagem.resultadoBusca(passagem);
				}else {
					System.out.println("Não existe essa passagem");
				}
				
				opcao = telaPassagem.mostraTelaPassagem();
				break;
				
            case 5:
            	PassagemDAOImp passagemBD4 = new PassagemDAOImp();
            	telaPassagem.resultadoLista(passagemBD4.passagem());
            	
            	opcao = telaPassagem.mostraTelaPassagem();
				break;
				
			case 6:
				ControllerPrincipal controlPrin = new ControllerPrincipal();
				break;
			}
				
		}while(opcao!=6);
		
					
	}
	
	public Passagem obtemPassagem(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a origem da passagem: ");
		String origem = sc.nextLine();
		System.out.println("Digite o destino da passagem: ");
		String destino = sc.nextLine();
		System.out.println("Digite a data da passagem: ");
		String data = sc.next();
		System.out.println("Digite a hora da passagem: ");
		String hora = sc.next();
		System.out.println("Digite o preço da passagem: ");
		double preco = sc.nextDouble();
		System.out.println("Passagem :     [1]Preferencial    [2]Normal");
		int res = sc.nextInt();
		String tipo;
		if(res == 1) {
			tipo = "preferencial";
		}else {
			tipo = "normal";
		}
		System.out.println("Digite o cod da passagem: ");
		String cod_passagem= sc.next();
		System.out.println("Selecione o onibus para viagem (Digite o id do ônibus)");
		String id_onibus= sc.next();
		
		Passagem passagem = new Passagem(origem, destino, data, hora, preco, tipo, cod_passagem, id_onibus,"disponivel");
		return passagem;
	}
	
	
	
}