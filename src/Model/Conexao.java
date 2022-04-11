package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

	public static Connection getConexao(){
		Connection con = null;
		String url = "jdbc:postgresql://localhost:5433/projeto";
		String usuario = "postgres";
		String senha = "banco";
		
		try{
			con = DriverManager.getConnection(url, usuario, senha);
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return con;
	}
	public static void desconecta(Connection con){
		try{
			con.close();
		}catch(SQLException ex){
			ex.printStackTrace();
			
		}
	}
}
