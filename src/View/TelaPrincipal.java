package View;

import java.util.Scanner;

public class TelaPrincipal {
	
	public TelaPrincipal(){
	}
	
	public int mostraTela(){
		Scanner sc = new Scanner (System.in);
		System.out.println(" 1 - Ir para tela do atendente \n"
						+ " 2 - Ir para tela do Onibus \n"
						+ " 3 - Ir para tela do passagem \n"
						+ " 4 - Ir para tela da venda \n"
				        + " 5 - Sair do programa \n");
		int opcao = sc.nextInt();
		return opcao;
	}
	
}