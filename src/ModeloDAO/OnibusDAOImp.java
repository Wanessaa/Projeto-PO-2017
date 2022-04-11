package ModeloDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Conexao;
import Model.Onibus;

public class OnibusDAOImp implements OnibusDAO {

	@Override
	public void inserirOnibus(Onibus onibus) {
		Connection con = Conexao.getConexao();
		String sqlInsert = "INSERT INTO onibus (tipo,status,num_poltrona,id) VALUES ('"+onibus.getTipo()+"','"+onibus.getStatus()+"','"+onibus.getNumPoltrona()+"',"+onibus.getId()+");";
		
		Statement stmInsert;
		
		try {
			stmInsert = con.createStatement();
			stmInsert.execute(sqlInsert);
			System.out.println("Ônibus inserido! \n ");
		}catch(SQLException atendenteEx) {
			atendenteEx.printStackTrace();
		}finally{
			Conexao.desconecta(con);
		}
		
	}

	@Override
	public void deletarOnibus(String id) {
		Connection con = Conexao.getConexao();
		String sqlDelete = "delete from onibus where id = '"+id+"' ";
		String sqlUpdateD = "update Venda set onibus_id= null where onibus_id = '"+id+"'";
		String sqlUpdateD1 = "update passagem set id_onibus= null where id_onibus = '"+id+"'";
		
		Statement stmDeletar;
		
		try{
			stmDeletar = con.createStatement();
			stmDeletar.execute(sqlUpdateD);
			stmDeletar.execute(sqlUpdateD1);
			
			
			stmDeletar.execute(sqlDelete);
			System.out.println("Ônibus removido! \n");
		}catch(SQLException onibusEx){
			onibusEx.printStackTrace();
		}finally{
			Conexao.desconecta(con);
		}
		
	}

	@Override
	public void atualizarOnibus(String idantigo,String tipo, String status, int numPoltrona, String id) {
		Connection con = Conexao.getConexao();
		String sqlAtualizar = "update onibus set tipo = '"+tipo+"',status='"+status+"',num_poltrona= "+numPoltrona+",id= '"+id+"' where id ='"+idantigo+"';";
		Statement stmAtualizar;
		
		try{
			stmAtualizar = con.createStatement();
			stmAtualizar.execute(sqlAtualizar);
			System.out.println("Ônibus atualizado! \n");
		}catch(SQLException onibusEx){
			onibusEx.printStackTrace();
		}finally{
			Conexao.desconecta(con);
		}
	}

	@Override
	public Onibus buscarOnibus(String id) {
		Connection con = Conexao.getConexao();
		String sqlBusca = "select * from Onibus where id = '"+id+"' ";
		Statement stmBuscar;
		
		try{
			stmBuscar = con.createStatement();
			ResultSet rs = stmBuscar.executeQuery(sqlBusca);
			Onibus onibus = null;
			while(rs.next()) {
				onibus = new Onibus(rs.getString("tipo"), rs.getString("status"), rs.getInt("num_poltrona"), rs.getString("id"));
			}
			return onibus;
			
		}catch(SQLException onibusEx){
			onibusEx.printStackTrace();
		}finally{
			Conexao.desconecta(con);
		}
		return null;
	}

	@Override
	public ArrayList<Onibus> onibus() {
		ArrayList<Onibus> arrayOnibus = new ArrayList<>();
		Connection con = Conexao.getConexao();
		String sqlListar = "select * from Onibus";
		Statement stmListar;
		
		try{
			stmListar = con.createStatement();
			ResultSet rs = stmListar.executeQuery(sqlListar);
			Onibus onibus = null;
			while(rs.next()) {
				onibus = new Onibus(rs.getString("tipo"), rs.getString("status"), rs.getInt("num_poltrona"), rs.getString("id"));
				arrayOnibus.add(onibus);
			}
			return arrayOnibus;
			
		}catch(SQLException atendenteEx){
			atendenteEx.printStackTrace();
		}finally{
			Conexao.desconecta(con);
		}
		return null;
	}

	
}
