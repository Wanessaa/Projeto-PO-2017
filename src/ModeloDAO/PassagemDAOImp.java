package ModeloDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Conexao;
import Model.Passagem;
import Model.Onibus;

public class PassagemDAOImp implements PassagemDAO {

	@Override
	public void inserirPassagem(Passagem passagem) {
		Connection con = Conexao.getConexao();
		String sqlInsert = "INSERT INTO Passagem (origem,destino,data,hora,preco,tipo,cod_passagem,id_onibus,status) VALUES ('"+passagem.getOrigem()+"','"+passagem.getDestino()+"','"+passagem.getData()+"','"+passagem.getHora()+"','"+passagem.getPreco()+"','"+passagem.getTipo()+"','"+passagem.getCod_passagem()+"' ,'"+passagem.getId_onibus()+"','"+passagem.getStatus()+"');";
		Statement stmInsert;
		
		try {
			stmInsert = con.createStatement();
			stmInsert.execute(sqlInsert);
			
			System.out.println("Passagem cadastrada!\n");
			
		}catch(SQLException passagemEx) {
			passagemEx.printStackTrace();
		}finally{
			Conexao.desconecta(con);
		}
		
	}

	@Override
	public void deletarPassagem(String cod) {
		Connection con = Conexao.getConexao();
		String sqlupdate = "update venda set cod_passagem = null  where cod_passagem = '"+cod+"'";
		String sqlDelete = "delete from Passagem where cod_passagem = '"+cod+"'";
		Statement stmDeletar;
		
		try{
			stmDeletar = con.createStatement();
			stmDeletar.execute(sqlupdate);
			stmDeletar.execute(sqlDelete);
			System.out.println("Passagem cancelada!\n");
		}catch(SQLException passagemEx){
			passagemEx.printStackTrace();
		}finally{
			Conexao.desconecta(con);
		}
	}

	@Override
	public Passagem buscarPassagem(String cod) {
		Connection con = Conexao.getConexao();
		String sqlUpdateD = "update passagem set id_onibus= null where id_onibus = '"+cod+"'";
		String sqlBusca = "select * from Passagem where cod_passagem= '"+cod+"' ;";
		Statement stmBuscar;
		
		try{
			stmBuscar = con.createStatement();
			ResultSet rs = stmBuscar.executeQuery(sqlBusca);
			Passagem passagem = null;
			while(rs.next()) {
			passagem = new Passagem(rs.getString("origem"), rs.getString("destino"), rs.getString("data"), rs.getString("hora"), rs.getDouble("preco"), rs.getString("tipo"), rs.getString("cod_passagem"), rs.getString("id_onibus"),rs.getString("Status"));
			}
			return passagem;
		}catch(SQLException passagemEx){
			passagemEx.printStackTrace();
		}finally{
			Conexao.desconecta(con);
		}
		
		return null;
	}

	@Override
	public ArrayList<Passagem> passagem() {
		ArrayList<Passagem> arrayPassagem = new ArrayList<>();
		Connection con = Conexao.getConexao();
		String sqlListar = "select * from Passagem";
		Statement stmListar;
		
		try{
			stmListar = con.createStatement();
			ResultSet rs = stmListar.executeQuery(sqlListar);
			Passagem passagem = null;
			while(rs.next()) {
				passagem = new Passagem(rs.getString("origem"), rs.getString("destino"), rs.getString("data"), rs.getString("hora"), rs.getDouble("preco"), rs.getString("tipo"), rs.getString("cod_passagem"), rs.getString("id_onibus"),rs.getString("Status"));
				arrayPassagem.add(passagem);
			}
			return arrayPassagem;
			
		}catch(SQLException passagemEx){
			passagemEx.printStackTrace();
		}finally{
			Conexao.desconecta(con);
		}
		return null;
	}

	@Override
	public void atualizarPassagem(String origem, String destino, String data, String hora, double preco, String tipo, String cod_passagem, String id, String codAltera) {
	
		Connection con = Conexao.getConexao();
		
		String sqlAtualizarv= "update Venda set cod_passagem='"+cod_passagem+"'where cod_passagem = '"+codAltera+"' ;";
		String sqlAtualizar = "update Passagem set origem = '"+origem+"', destino = '"+destino+"', data = '"+data+"', hora = '"+hora+"', preco = '"+preco+"', tipo = '"+tipo+"', cod_passagem = '"+cod_passagem+"', id_onibus = '"+id+"' where cod_passagem = '"+codAltera+"' ;";
		Statement stmAtualizar;
		
		
		try{
			stmAtualizar = con.createStatement();
			stmAtualizar.execute(sqlAtualizarv);
			stmAtualizar.execute(sqlAtualizar);
			System.out.println("passagem atualizada!");
		}catch(SQLException passagemEx){
			passagemEx.printStackTrace();
		}finally{
			Conexao.desconecta(con);
		}
		
	}

	
}
