package ModeloDAO;

import java.util.ArrayList;

import Model.Onibus;

public interface OnibusDAO {

	public void inserirOnibus(Onibus onibus);
	public void deletarOnibus(String id);
	public void atualizarOnibus(String idantigo,String tipo, String status, int numPoltrona, String id);
	public Onibus buscarOnibus(String id);
	public ArrayList<Onibus> onibus();

}
