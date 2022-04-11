package Controller;

import java.util.Scanner;

import Model.Atendente;
import Model.Onibus;
import ModeloDAO.AtendenteDAOImp;
import ModeloDAO.OnibusDAOImp;
import View.AtendenteGUI;
import View.OnibusGUI;
import View.TelaPrincipal;

public class ControllerOnibus {
	private OnibusGUI telaOnibus;

	ControllerOnibus(){
		telaOnibus = new OnibusGUI();
		acoes();
	}

	public void acoes (){
		int opcao = telaOnibus.mostraTelaOnibus();
		do{
			switch(opcao){
			case 1:
				OnibusDAOImp onibusBD = new OnibusDAOImp();
				onibusBD.inserirOnibus(obtemOnibus());
				opcao = telaOnibus.mostraTelaOnibus();
				break;

				
				
			case 2:
				OnibusDAOImp onibusBDdeletar = new OnibusDAOImp();
				Scanner scan = new Scanner (System.in);
				System.out.println("digite qual o id do onibus que deseja remover");
				String id = scan.next();

				Onibus onibus = onibusBDdeletar.buscarOnibus(id);
				if(onibus != null) {
					onibusBDdeletar.deletarOnibus(id);

				}else {
					System.out.println("Não existe onibus com esse id");
				}

				opcao = telaOnibus.mostraTelaOnibus();
				break;
				
				
				
			case 3:
				OnibusDAOImp onibusBDalterar = new OnibusDAOImp();
				Scanner sc = new Scanner(System.in);
				System.out.println("Digite o id do onibus que deseja atualizar :");
				String id1 = sc.next();
				Onibus onibusAlt = onibusBDalterar.buscarOnibus(id1);
				if(onibusAlt != null) {
					System.out.println("Ônibus : \n [1]Preferencial \n [2]Leito \n [3]Executivo \n [4]Convencional \n [5]Outro:");
					int res = sc.nextInt();
					String tipo = null;
					if(res == 1) {
						tipo = "preferencial";}
					if(res == 2) {
						tipo = "leito";}
					if(res == 3) {
						tipo = "executivo";}
					if(res == 4) {
						tipo = "convencional";}
					if(res == 5) {
						tipo = sc.next();}
					
					
					System.out.println("Ônibus :     [1]ocupado   [2]disponivel");
					int rese= sc.nextInt();
					String status;
					if(rese == 1) {
						status = "ocupado";
					}else {
						status = "disponivel";
					}
					System.out.println("Digite o número de poltronas: ");
					int numPoltrona = sc.nextInt();
					
					System.out.println("Digite o id: ");
					String idAlt = sc.next();
				
					onibusBDalterar.atualizarOnibus(id1,tipo, status, numPoltrona, idAlt);
				}else {
					System.out.println("não existe esse onibus");
				}
				opcao = telaOnibus.mostraTelaOnibus();
				break;
				
				
			case 4:
				OnibusDAOImp onibusBD3 = new OnibusDAOImp();
				System.out.println("Digite o id do onibus que deseja buscar:");
				Scanner buscar = new Scanner(System.in);
				String idB = buscar.next();

				Onibus onibusB = onibusBD3.buscarOnibus(idB);
				if(onibusB != null) {
					OnibusGUI.resultadoBusca(onibusB);
				}else {
					System.out.println("Não existe esse ônibus");
				}
				opcao = telaOnibus.mostraTelaOnibus();

				break;
			case 5:
				OnibusDAOImp onibusBD2 = new OnibusDAOImp();
				telaOnibus.resultadoLista(onibusBD2.onibus());
				opcao = telaOnibus.mostraTelaOnibus();

				break;
			case 6:

				ControllerPrincipal controlPrin = new ControllerPrincipal();
				break;
			}

		}while(opcao!=6);




	}

	public Onibus obtemOnibus(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Ônibus : \n [1]Preferencial \n [2]Leito \n [3]Executivo \n [4]Convencional \n [5]Outro:");
		int res = sc.nextInt();
		String tipo= null;
		if(res == 1) {
			tipo = "preferencial";}
		if(res == 2) {
			tipo = "leito";}
		if(res == 3) {
			tipo = "executivo";}
		if(res == 4) {
			tipo = "convencional";}
		if(res == 5) {
			tipo = sc.next();}

		
		System.out.println("Ônibus :     [1]ocupado   [2]disponivel");
		int rese= sc.nextInt();
		String status;
		if(res == 1) {
			status = "ocupado";
		}else {
			status = "disponivel";
		}
		System.out.println("Digite o número de poltronas: ");
		int numPoltrona = sc.nextInt();
		System.out.println("Digite o id: ");
		String id = sc.next();

		Onibus atendente = new Onibus( tipo,status,numPoltrona,id);
		return atendente;
	}


	}
