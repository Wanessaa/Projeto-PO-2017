package ModeloDAO;

import java.util.ArrayList;

import Model.Passagem;

public interface PassagemDAO {

	public void inserirPassagem(Passagem passagem);
	public void deletarPassagem(String cod);
	public void atualizarPassagem(String origem,String destino,String data,String hora,double preco,String tipo,String cod_passagem,String id, String codAlter);
	public Passagem buscarPassagem(String cod);
	public ArrayList<Passagem> passagem();
}
