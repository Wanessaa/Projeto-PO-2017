package Controller;

import java.util.Scanner;

import Model.Atendente;
import ModeloDAO.AtendenteDAOImp;
import View.AtendenteGUI;
import View.TelaPrincipal;

public class ControllerAtendente {
	private AtendenteGUI telaAtendente;
		
	ControllerAtendente(){
		telaAtendente = new AtendenteGUI();
		acoes();
	}
	
	public void acoes (){
		int opcao = telaAtendente.mostraTelaAtendente();
		do{
			switch(opcao){
			case 1:
				AtendenteDAOImp atendenteBD = new AtendenteDAOImp();
				atendenteBD.inserirAtendente(obtemAtendente());
				
				opcao = telaAtendente.mostraTelaAtendente();
				break;
				
			case 2:
				AtendenteDAOImp atendenteBDdeletar = new AtendenteDAOImp();
				telaAtendente.resultadoLista(atendenteBDdeletar.listarAtendente());
				Scanner scan = new Scanner (System.in);
				System.out.println("digite qual o código do atendente que deseja remover:");
				
				String cod = scan.next();
			    
				Atendente ate1 = atendenteBDdeletar.buscarAtendente(cod);
            	if(ate1 != null) {
            		atendenteBDdeletar.deletarAtendente(cod);
            	}else {
            		System.out.println("Não existe esse atendente");
            	}
				
            	
            	
            	opcao = telaAtendente.mostraTelaAtendente();
				
				break;
            case 3:
            	AtendenteDAOImp atendenteBDalterar = new AtendenteDAOImp();
				Scanner sc = new Scanner (System.in);
				System.out.println("digite o cod do atendente que deseja alterar:");
				String codantigo= sc.next();
				Atendente ate = atendenteBDalterar.buscarAtendente(codantigo);
            	if(ate != null) {
            		System.out.println("digite qual o novo codigo cod ");
    				String codi = sc.next();
    				System.out.println("digite o cpf ");
    				String cpf= sc.next();
    				System.out.println("digite o nome");
    				String nome = sc.next();
            		
            		atendenteBDalterar.atualizarAtendente(codantigo,codi, cpf, nome);
            	}else {
            		System.out.println("Não existe esse atendente");
            		
            	}
				
            	opcao = telaAtendente.mostraTelaAtendente();
				
				break;
					
            case 4:
            	AtendenteDAOImp atendenteBD1 = new AtendenteDAOImp();
            	System.out.println("Digite o cpf para buscar");
            	Scanner busca = new Scanner(System.in);
            	String cpf = busca.next();
            	Atendente aten = atendenteBD1.buscarAtendente(cpf);
            	if(aten != null) {
            		AtendenteGUI.resultadoBusca(aten);
            	}else {
            		System.out.println("Não existe esse atendente");
            	}
            	opcao = telaAtendente.mostraTelaAtendente();
				break;
            case 5:
            	AtendenteDAOImp atendenteBD2 = new AtendenteDAOImp();
				telaAtendente.resultadoLista(atendenteBD2.listarAtendente());
				opcao = telaAtendente.mostraTelaAtendente();
				break;
			case 6:
				ControllerPrincipal controlPrin = new ControllerPrincipal();
				break;
			}
				
		}while(opcao!=6);
		
		
				
	}
	
	public Atendente obtemAtendente(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o código do atendente: ");
		String cod = sc.next();
		System.out.println("Digite o cpf do atendente: ");
		String cpf = sc.next();
		System.out.println("Digite o nome do atendente: ");
		String nome = sc.next();
		
		Atendente atendente = new Atendente(cod,cpf,nome);
		return atendente;
	}
	
	
	
}