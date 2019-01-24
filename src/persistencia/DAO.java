package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	

	Connection con; // 
	PreparedStatement stmt;// 
	ResultSet rs; // 

	public void abrirConexao() throws Exception {
		
		con = DriverManager.getConnection("jdbc:mysql:localhost:3306/ProjetoMod3", "root", "");
	}

	public void fecharConexao() throws Exception {
		con.close();
	}

	public static void main(String[] args) {

		try {
			DAO t = new DAO();
			t.abrirConexao();
			System.out.println("conectei");
		} catch (Exception e) {
			System.out.println("erro ao conectar");
			// TODO: handle exception
		}
	}
}
	


