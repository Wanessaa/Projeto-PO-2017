package ModeloDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Atendente;
import Model.Conexao;


public  class AtendenteDAOImp implements AtendenteDAO {

	@Override
	public void inserirAtendente(Atendente atendente) {
		Connection con = Conexao.getConexao();
		String sqlInsert = "INSERT INTO Atendente (cod,cpf,nome) VALUES ("+atendente.getCod()+",'"+atendente.getCpf()+"','"+atendente.getNome()+"');";
		System.out.println("Atendente cadastrado! \n");
		Statement stmInsert;
		
		try {
			stmInsert = con.createStatement();
			stmInsert.execute(sqlInsert);
		}catch(SQLException atendenteEx) {
			atendenteEx.printStackTrace();
		}finally{
			Conexao.desconecta(con);
		}
		
	}

	@Override
	public void deletarAtendente(String cod) {
		Connection con = Conexao.getConexao();
		String sqlUpdateD = "update Venda set cod_atendente= null where cod_atendente = '"+cod+"'";
		String sqlDelete = "delete from atendente where cod = '"+cod+"'";
		
		Statement stmDeletar;
		
		try{
			stmDeletar = con.createStatement();
			stmDeletar.execute(sqlUpdateD);
			stmDeletar.execute(sqlDelete);
			System.out.println("Atendente removido! \n");
		}catch(SQLException atendenteEx){
			atendenteEx.printStackTrace();
		}finally{
			Conexao.desconecta(con);
		}
	}
	
    @Override
	public void atualizarAtendente(String codantigo,String cod,String cpf,String nome) {
		Connection con = Conexao.getConexao();
		String sqlAtualizar = "update atendente set cod = '"+cod+"',cpf= '"+cpf+"',nome='"+nome+"' where cod = '"+codantigo+"' ;";
		System.out.println("Atendente atualizado! \n");
		Statement stmAtualizar;
		
		try{
			stmAtualizar = con.createStatement();
			stmAtualizar.execute(sqlAtualizar);
		}catch(SQLException atendenteEx){
			atendenteEx.printStackTrace();
		}finally{
			Conexao.desconecta(con);
		}
	}

	@Override
	public Atendente buscarAtendente(String cod) {
		Connection con = Conexao.getConexao();
		String sqlBusca = "select * from Atendente where cod = '"+cod+"' ;";
		Statement stmBuscar;
		
		try{
			stmBuscar = con.createStatement();
			ResultSet rs = stmBuscar.executeQuery(sqlBusca);
			Atendente atendente = null;
			while(rs.next()) {
				atendente = new Atendente(rs.getString("cod"), rs.getString("cpf"), rs.getString("nome"));
			}
			return atendente;
			
		}catch(SQLException atendenteEx){
			atendenteEx.printStackTrace();
		}finally{
			Conexao.desconecta(con);
		}
		return null;
	}

	@Override
	public ArrayList<Atendente> listarAtendente () {
		ArrayList<Atendente> arrayAtendente = new ArrayList<>();
		Connection con = Conexao.getConexao();
		String sqlListar = "select * from Atendente";
		Statement stmListar;
		
		try{
			stmListar = con.createStatement();
			ResultSet rs = stmListar.executeQuery(sqlListar);
			Atendente atendente = null;
			while(rs.next()) {
				atendente = new Atendente(rs.getString("cod"), rs.getString("cpf"), rs.getString("nome"));
				arrayAtendente.add(atendente);
			}
			return arrayAtendente;
			
		}catch(SQLException atendenteEx){
			atendenteEx.printStackTrace();
		}finally{
			Conexao.desconecta(con);
		}
		
		return null;
	}	
}
