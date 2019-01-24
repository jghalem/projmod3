package persistencia;


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DAO {

    Connection con; // controlar acesso db
    PreparedStatement stmt; // manipula instrução
    ResultSet rs; // manipula resultados

    public void abrirConexao() throws Exception {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tb_cliente", "root", "");
    }

    public void fecharConexao() throws Exception {
        con.close();
    }
    
    public static void main(String[] args) {
		try {
			DAO t = new DAO();
			t.abrirConexao();
			System.out.println("Conectei");
		} catch (Exception e) {
			System.out.println("Erro ao conectar");
		}
	}
}
