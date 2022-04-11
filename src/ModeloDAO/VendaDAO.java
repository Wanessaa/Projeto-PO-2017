package ModeloDAO;

import java.util.ArrayList;

import Model.Venda;

public interface VendaDAO {

	public void inserirVenda(Venda venda);
	public void deletarVenda(String id);
	public void atualizarVenda(String idAntigo,String cod_atendente, String cod_passagem, String onibus_id,String nome_cliente
			,String id, String cpf_comprador,String datanasc, String rg,String hora,boolean preferencial);
	public Venda buscarVenda(String id);
	public ArrayList<Venda> venda();
}
