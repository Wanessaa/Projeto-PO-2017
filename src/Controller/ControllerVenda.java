package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Model.Atendente;
import Model.Conexao;
import Model.Passagem;
import Model.Venda;
import ModeloDAO.VendaDAOImp;
import View.VendaGUI;
import View.TelaPrincipal;

public class ControllerVenda {
	private VendaGUI telaVenda;
	
	ControllerVenda(){
		telaVenda = new VendaGUI();
		acoes();
	}
	
	public void acoes (){
		int opcao = telaVenda.mostraTelaVenda();
		do{
			switch(opcao){
			case 1:
				VendaDAOImp vendaBD = new VendaDAOImp();
				vendaBD.inserirVenda(obtemVenda());
				
				opcao = telaVenda.mostraTelaVenda();
				break;
			case 2:
				VendaDAOImp vendaBD1 = new VendaDAOImp();
				Scanner delete = new Scanner(System.in);
				System.out.println("Digite id da venda que será cancelada");
				String idDelete = delete.next();
				
				Venda vendaDelete = vendaBD1.buscarVenda(idDelete);
				if(vendaDelete != null) {
					vendaBD1.deletarVenda(idDelete);
				}else {
					System.out.println("Não foi registrada essa venda");
				}
				
				opcao = telaVenda.mostraTelaVenda();
				break;
            case 3:
            	VendaDAOImp vendaBD2 = new VendaDAOImp();
            	Scanner atualizar = new Scanner(System.in);
            	System.out.println("Digite o id ");
				String idAtualizar = atualizar.next();
				
				Venda vendaAtualizar = vendaBD2.buscarVenda(idAtualizar);
				if(vendaAtualizar != null) {
					System.out.println("Digite nome do cliente ");
					String nome = atualizar.next();
					System.out.println("Digite cpf do cliente");
					String cpf = atualizar.next();
					System.out.println("Digite rg do cliente");
					String rg = atualizar.next();
					System.out.println("Data de nascimento do cliente");
					String data = atualizar.next();
					System.out.println("Passagem :     [1]Preferencial    [2]Normal");
					int res = atualizar.nextInt();
					boolean preferencial;
					if(res == 1) {
						preferencial = true;
					}else {
						preferencial = false;
					}
					System.out.println("Hora da viagem");
					String hora = atualizar.next();
					System.out.println("Codigo atendente:");
					String codAte =  atualizar.next();
					System.out.println("Cod passagem:");
					String codPas = atualizar.next();
					System.out.println("Id do onibus:");
					String idOni = atualizar.next();
					System.out.println("Id da venda");
					String id =  atualizar.next();
					vendaBD2.atualizarVenda(idAtualizar, codAte, codPas, idOni, nome, id, cpf, data, rg, hora, preferencial);
				}else {
					System.out.println("Não foi registrada essa venda");
				}
				
				opcao = telaVenda.mostraTelaVenda();
				break;
            case 4:
            	VendaDAOImp vendaBD3 = new VendaDAOImp();
            	Scanner buscar = new Scanner(System.in);
            	System.out.println("Digite o id");
				String idBusca = buscar.next();
				
				Venda vendaBusca = vendaBD3.buscarVenda(idBusca);
				if(vendaBusca != null) {
					telaVenda.resultadoBusca(vendaBusca);
				}else {
					System.out.println("Não foi registrada essa venda");
				}
				
				opcao = telaVenda.mostraTelaVenda();
				break;
            case 5:
            	VendaDAOImp vendaBD4 = new VendaDAOImp();
            	telaVenda.resultadoLista(vendaBD4.venda());
            	
            	opcao = telaVenda.mostraTelaVenda();
				break;
			case 6:
				ControllerPrincipal controlPrin = new ControllerPrincipal();
				break;
			}
				
		}while(opcao!=6);
		
		
				
		
		
				
	}
	
	public Venda obtemVenda(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a origem: ");
		String origem = sc.next();
		System.out.println("Digite o destino:");
		String destino = sc.next();
		
		Connection con = Conexao.getConexao();
		String sqlSeTemPassagem = "select origem, destino,Status from passagem";
		Statement stmSeTem;
		try{
			stmSeTem = con.createStatement();
			ResultSet rs = stmSeTem.executeQuery(sqlSeTemPassagem);
			boolean res = false;
			while(rs.next()) {
				if(rs.getString("origem").equals(origem) && rs.getString("destino").equals(destino) && rs.getString("Status").equals("disponível")) {
					res = true;
				}
			}
			if(res == true) {
				System.out.println("\nResponda as demais perguntar para concluir essa passagem\n");
			}else {
				System.out.println("Essa passagem não está disponivel\n");
			}
			
		}catch(SQLException atendenteEx){
			atendenteEx.printStackTrace();
		}finally{
			Conexao.desconecta(con);
		}
		
		
		
			Scanner scan = new Scanner(System.in);
			System.out.println("Digite o código do atendente que o auxiliou: ");
			String cod_atendente= sc.next();
			System.out.println("Escolha a passagem que deseja digitando o id : ");
			String cod_passagem = sc.next();
			System.out.println("Escolha o ônibus que deseja viajar digitando o id : ");
			String onibus_id = sc.next();
			System.out.println("Digite seu nome: ");
			String nome_cliente = sc.next();
			System.out.println("Digite o seu cpf: ");
			String cpf_comprador = sc.next();
			System.out.println("Digite sua data de nascimento: ");
			String datanasc = sc.next();
			System.out.println("Digite o seu rg: ");
			String rg = sc.next();
			System.out.println("Digite hora da compra: ");
			String hora = sc.next();
			System.out.println("Passagem :     [1]Preferencial    [2]Normal");
			int res = sc.nextInt();
			boolean preferencial;
			if(res == 1) {
				preferencial = true;
			}else {
				preferencial = false;
			}
			System.out.println("Digite id da venda");
			String id = sc.next();
			
			
			Venda venda = new Venda(cod_atendente, cod_passagem, onibus_id, nome_cliente,id, cpf_comprador, datanasc, rg, hora, preferencial);
			return venda;
		}
		
		
}
	
	
	
