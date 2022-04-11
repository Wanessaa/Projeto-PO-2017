package ModeloDAO;

import java.util.ArrayList;

import Model.Atendente;

public interface AtendenteDAO {

	public void inserirAtendente(Atendente atendente);
	public void deletarAtendente(String cpf);
	public void atualizarAtendente(String codantigo,String cod,String cpf, String nome);
	public Atendente buscarAtendente(String cpf);
	public ArrayList<Atendente> listarAtendente();
}
