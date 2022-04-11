package ModeloDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Conexao;
import Model.Venda;

public class VendaDAOImp implements VendaDAO{

	@Override
	public void inserirVenda(Venda venda) {
		Connection con = Conexao.getConexao();
		String sqlInsert = "INSERT INTO Venda (cod_atendente,cod_passagem,onibus_id,nome_cliente,id,cpf_comprador,datanasc,rg,hora,preferencial) VALUES ('"+venda.getCod_atendente()+"','"+venda.getCod_passagem()+"','"+venda.getOnibus_id()+"','" +venda.getNome_cliente()+"',"+venda.getId()+",'"+venda.getCpf_comprador()+"','"+venda.getDatanasc()+"','"+venda.getRg()+"','"+venda.getHora()+"',"+venda.getPreferencial()+");";;
        String sqlaltera = "update passagem set Status = 'comprado' where cod_passagem='" +venda.getCod_passagem()+"'";
				Statement stmInsert;

				try {
					stmInsert = con.createStatement();
					stmInsert.execute(sqlInsert);
					stmInsert.execute(sqlaltera);
					
					System.out.println("Venda efetuada!\n");
				}catch(SQLException vendaEx) {
					vendaEx.printStackTrace();
				}finally{
					Conexao.desconecta(con);
				}
	}
	

	@Override
	public void deletarVenda(String id) {
		Connection con = Conexao.getConexao();
		String sqlDelete = "delete from Venda where id= '"+id+"'";
		Statement stmDeletar;

		try{
			stmDeletar = con.createStatement();
			stmDeletar.execute(sqlDelete);
			System.out.println("Sua venda foi cancelada!\n");
		}catch(SQLException vendaEx){
			vendaEx.printStackTrace();
		}finally{
			Conexao.desconecta(con);
		}
	}

	@Override
	public void atualizarVenda(String idAntigo,String cod_atendente, String cod_passagem, String onibus_id,String nome_cliente
			,String id, String cpf_comprador,String datanasc, String rg, String hora, boolean preferencial) {
		
		Connection con = Conexao.getConexao();
		String sqlAtualizar = "update Venda set cod_atendente = '"+cod_atendente+"', cod_passagem = '"+cod_passagem+"', onibus_id = '"+onibus_id+"', nome_cliente = '"+nome_cliente+"', id = "+id+", cpf_comprador = '"+cpf_comprador+"', datanasc = '"+datanasc+"', rg = '"+rg+"', hora = '"+hora+"', preferencial = '"+preferencial+"' where id = '"+idAntigo+"' ;";
		Statement stmAtualizar;
		

		try{
			stmAtualizar = con.createStatement();
			stmAtualizar.execute(sqlAtualizar);
			System.out.println("Sua venda foi atualizada!\n");
		}catch(SQLException vendaEx){
			vendaEx.printStackTrace();
		}finally{
			Conexao.desconecta(con);
		}
	}

	@Override
	public Venda buscarVenda(String id) {
		Connection con = Conexao.getConexao();
		String sqlBuscar = "select * from Venda where id = '"+id+"' ;";
        Statement stmBuscar;
		
		try{
			stmBuscar = con.createStatement();
			ResultSet rs = stmBuscar.executeQuery(sqlBuscar);
			Venda venda = null;
			while(rs.next()) {
		       venda = new Venda(rs.getString("cod_atendente"), rs.getString("cod_passagem"), rs.getString("onibus_id"), rs.getString("nome_cliente"), rs.getString("id"), rs.getString("cpf_comprador"), rs.getString("datanasc"), rs.getString("rg"), rs.getString("hora"), rs.getBoolean("preferencial"));
			}
			return venda;
			
		}catch(SQLException vendaEx){
			vendaEx.printStackTrace();
		}finally{
			Conexao.desconecta(con);
		}
		return null;
	}

	@Override
	public ArrayList<Venda> venda() {
		ArrayList<Venda> arrayVenda = new ArrayList<>();
		Connection con = Conexao.getConexao();
		String sqlListar = "select * from Venda";
		Statement  stmListar;
		
		try{
			stmListar = con.createStatement();
			ResultSet rs = stmListar.executeQuery(sqlListar);
			Venda venda = null;
			while(rs.next()) {
				venda = new Venda(rs.getString("cod_atendente"), rs.getString("cod_passagem"), rs.getString("onibus_id"), rs.getString("nome_cliente"), rs.getString("id"), rs.getString("cpf_comprador"), rs.getString("datanasc"), rs.getString("rg"), rs.getString("hora"), rs.getBoolean("preferencial"));
				arrayVenda.add(venda);
			}
			return arrayVenda;
			
		}catch(SQLException vendaEx){
			vendaEx.printStackTrace();
		}finally{
			Conexao.desconecta(con);
		}
		return null;
	}



}
