package Controller;

import View.TelaPrincipal;

public class ControllerPrincipal {
	private TelaPrincipal tela ;
	public ControllerPrincipal(){
		tela = new TelaPrincipal();
		acaoPrincipal();
	}
	
	public void acaoPrincipal(){
		int acao = tela.mostraTela();
		
		switch(acao){
			case 1:
				ControllerAtendente controlAtendente = new ControllerAtendente();
				break;
			case 2:
				ControllerOnibus controlOnibus = new ControllerOnibus();
				break;
			case 3:
				ControllerPassagem controlPassagem = new ControllerPassagem();
				break;
			case 4:
				ControllerVenda controlVenda = new ControllerVenda();
				break;
			case 5:
				System.out.println("programa finalizado");
				System.exit(0);
				break;
			
		}
		
	}
}
